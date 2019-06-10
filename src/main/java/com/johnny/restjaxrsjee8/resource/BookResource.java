package com.johnny.restjaxrsjee8.resource;

import java.net.URI;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.johnny.restjaxrsjee8.dto.BookDTO;
import com.johnny.restjaxrsjee8.exception.BookAlreadyExistsException;
import com.johnny.restjaxrsjee8.exception.BookDoesNotExistException;
import com.johnny.restjaxrsjee8.factory.BookFactory;
import com.johnny.restjaxrsjee8.model.Book;
import com.johnny.restjaxrsjee8.service.BookService;

@Path("books")
@RequestScoped
public class BookResource {

	@Inject
	BookService service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response fetchAll() {
		List<Book> books = service.getAllBooks();
		return Response.ok(books).build();
	}

	@GET
	@Path("/{isbn}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("isbn") String isbn) {
		Book book = service.getBookByISBN(isbn);
		return Response.ok(book != null ? book : "Book not found").build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(BookDTO book) {
		Book createdBook = service.addBook(BookFactory.getBook(book));
		if (createdBook == null)
			throw new BookAlreadyExistsException("Book already exists!");
		URI location = UriBuilder.fromResource(BookResource.class).path("/{isbn}")
				.resolveTemplate("isbn", createdBook.getIsbn()).build();
		return Response.created(location).build();
	}

	@PUT
	@Path("/{isbn}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("isbn") String isbn, BookDTO book) {
		if (service.getBookByISBN(isbn) == null)
			throw new BookDoesNotExistException("Book does not exist!");
		service.updateBook(isbn, BookFactory.getBook(book));
		return Response.ok().build();
	}

	@DELETE
	@Path("/{isbn}")
	public Response delete(@PathParam("isbn") String isbn) {
		service.deleteBook(isbn);
		return Response.ok().build();
	}

}
