package com.johnny.restjaxrsjee8.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Custom exception for when you want to update a book but the same does not
 * exist.<br>
 * This inherits from {@link WebApplicationException} instead of implementing a
 * custom {@link ExceptionMapper}
 * 
 * @author Johnny do Amaral
 * 
 */
public class BookDoesNotExistException extends WebApplicationException {

	private static final long serialVersionUID = -4793015404071926420L;

	public BookDoesNotExistException() {
		super(Response.status(Status.NOT_FOUND).build());
	}

	public BookDoesNotExistException(String message) {
		super(Response.status(Status.NOT_FOUND).entity(message).type(MediaType.TEXT_PLAIN).build());
	}
}
