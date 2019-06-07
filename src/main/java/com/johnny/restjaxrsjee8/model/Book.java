package com.johnny.restjaxrsjee8.model;

public class Book {

	private String isbn;
	private String name;
	private String author;
	private String year;
	private String genre;
	private String publisher;

	public Book() {

	}

	public Book(String isbn, String name, String author, String year, String genre, String publisher) {
		this.isbn = isbn;
		this.name = name;
		this.author = author;
		this.year = year;
		this.genre = genre;
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public String getYear() {
		return year;
	}

	public String getGenre() {
		return genre;
	}

	public String getPublisher() {
		return publisher;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Book))
			return false;
		Book other = (Book) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}

}
