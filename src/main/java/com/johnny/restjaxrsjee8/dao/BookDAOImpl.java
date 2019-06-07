package com.johnny.restjaxrsjee8.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.johnny.restjaxrsjee8.model.Book;

public class BookDAOImpl implements BookDAO {

	private Set<Book> books = new HashSet<>();

	{
		books.add(
				new Book("9780141439563", "Great Expectations", "Charles Dickens", "1861", "Novel", "Chapman & Hall"));
		books.add(new Book("0451208633", "The Divine Comedy", "Dante Alighieri", "2003", "Poem", "Berkley"));
		books.add(new Book("1507547269", "Faust: Parts I & II ", "Goethe", "2015", "Drama",
				"CreateSpace Independent Publishing Platform"));
	}

	public Book get(String isbn) {
		for (Book book : books) {
			if (book.getIsbn().equalsIgnoreCase(isbn))
				return book;
		}
		return null;
	}

	public List<Book> findAll() {
		return books.stream().collect(Collectors.toList());
	}

	public Book update(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(String isbn) {
		Book book = null;
		for (Book b : books) {
			if (b.getIsbn().equalsIgnoreCase(isbn))
				book = b;
		}
		if (book != null)
			books.remove(book);
	}

	public Book create(Book book) {
		books.add(book);
		return get(book.getIsbn());

	}
}
