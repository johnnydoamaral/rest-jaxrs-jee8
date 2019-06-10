package com.johnny.restjaxrsjee8.dao;

import java.util.List;

import com.johnny.restjaxrsjee8.model.Book;

public interface BookDAO {

	Book get(String isbn);

	List<Book> findAll();

	void update(Book book);

	void delete(String isbn);
	
	Book create(Book book);

}
