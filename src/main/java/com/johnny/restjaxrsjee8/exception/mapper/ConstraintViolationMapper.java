package com.johnny.restjaxrsjee8.exception.mapper;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationMapper implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		List<String> messages = exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
				.collect(Collectors.toList());
		return Response.status(Status.BAD_REQUEST).entity(messages).build();
	}

}
