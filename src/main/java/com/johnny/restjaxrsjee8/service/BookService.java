package com.johnny.restjaxrsjee8.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.johnny.restjaxrsjee8.dao.BookDAO;
import com.johnny.restjaxrsjee8.model.Book;

@ApplicationScoped
public class BookService {

	@Inject
	BookDAO dao;

	public List<Book> getAllBooks() {
		return dao.findAll();
	}

	public Book getBookByISBN(String isbn) {
		return dao.get(isbn);
	}

	public Book addBook(Book book) {
		return dao.create(book);
	}

	public void updateBook(String isbn, Book book) {
		dao.delete(isbn);
		dao.update(book);
	}
	
	public void deleteBook(String isbn) {
		dao.delete(isbn);
	}
}
