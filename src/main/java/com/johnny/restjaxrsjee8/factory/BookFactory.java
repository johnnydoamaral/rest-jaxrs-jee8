package com.johnny.restjaxrsjee8.factory;

import com.johnny.restjaxrsjee8.dto.BookDTO;
import com.johnny.restjaxrsjee8.model.Book;

public class BookFactory {

	public static Book getBook(BookDTO bookDTO) {
		return new Book(bookDTO.getIsbn(), bookDTO.getName(), bookDTO.getAuthor(), bookDTO.getYear(),
				bookDTO.getGenre(), bookDTO.getPublisher());
	}
}
