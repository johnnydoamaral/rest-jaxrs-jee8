package com.johnny.restjaxrsjee8.dto;

import javax.validation.constraints.NotEmpty;

public class BookDTO {

	@NotEmpty(message = "Field ISBN cannot be empty.")
	private String isbn;
	@NotEmpty(message = "Field NAME cannot be empty.")
	private String name;
	@NotEmpty(message = "Field AUTHOR cannot be empty.")
	private String author;
	@NotEmpty(message = "Field YEAR cannot be empty.")
	private String year;
	@NotEmpty(message = "Field GENRE cannot be empty.")
	private String genre;
	@NotEmpty(message = "Field PUBLISHER cannot be empty.")
	private String publisher;

	public BookDTO() {

	}

	public BookDTO(String isbn, String name, String author, String year, String genre, String publisher) {
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

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

}
