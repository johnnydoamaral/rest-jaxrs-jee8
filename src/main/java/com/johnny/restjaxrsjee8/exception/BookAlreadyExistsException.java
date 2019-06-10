package com.johnny.restjaxrsjee8.exception;

import javax.ws.rs.ext.ExceptionMapper;

/**
 * Custom exception for when you want to add a new book but the same cannot be
 * created because it already exists. <br>
 * This uses a custom {@link ExceptionMapper} to have the proper response
 * correctly mapped.<br>
 * 
 * @author Johnny do Amaral
 *
 */
public class BookAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 3983643030013808858L;

	public BookAlreadyExistsException(String message) {
		super(message);
	}

}
