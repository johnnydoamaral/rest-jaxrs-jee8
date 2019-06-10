package com.johnny.restjaxrsjee8.exception.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.johnny.restjaxrsjee8.exception.BookAlreadyExistsException;

@Provider
public class BookAlreadyExistsMapper implements ExceptionMapper<BookAlreadyExistsException> {

	@Override
	public Response toResponse(BookAlreadyExistsException exception) {
		return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
	}

}
