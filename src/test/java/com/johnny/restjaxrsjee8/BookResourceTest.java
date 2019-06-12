package com.johnny.restjaxrsjee8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import com.johnny.restjaxrsjee8.dao.BookDAO;
import com.johnny.restjaxrsjee8.dao.BookDAOImpl;
import com.johnny.restjaxrsjee8.dto.BookDTO;
import com.johnny.restjaxrsjee8.resource.BookResource;
import com.johnny.restjaxrsjee8.service.BookService;

public class BookResourceTest extends JerseyTest {

	@Override
	protected Application configure() {
		ResourceConfig config = new ResourceConfig(BookResource.class);
		// Necessary for dependency injection to work:
		config.register(new AbstractBinder() {
			@Override
			protected void configure() {
				bind(BookDAOImpl.class).to(BookDAO.class);
				bind(BookService.class).to(BookService.class);
			}
		});
		return config;
	}

	@Test
	public void testGETBooks() {
		Response response = target("books").request().get();
		String responseBody = response.readEntity(String.class).toLowerCase();
		assertEquals(Status.OK.getStatusCode(), response.getStatus());
		assertEquals(MediaType.APPLICATION_JSON, response.getHeaderString(HttpHeaders.CONTENT_TYPE));
		assertNotNull(responseBody);
		assertTrue(responseBody.contains("isbn"));
		assertTrue(responseBody.contains("name"));
		assertTrue(responseBody.contains("author"));
	}

	@Test
	public void testPOSTBook() {
		BookDTO book = new BookDTO("9781853260407", "The Three Musketeers", "Alexandre Dumas", "1997",
				"Adventure novel", "Wordsworth Editions Ltd");
		Response response = target("books").request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(book, MediaType.APPLICATION_JSON));
		String location = response.getHeaderString(HttpHeaders.LOCATION);
		assertEquals(Status.CREATED.getStatusCode(), response.getStatus());
		assertNotNull(location);
		assertTrue(!location.isEmpty());
	}
	
}
