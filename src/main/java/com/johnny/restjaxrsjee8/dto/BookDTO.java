package com.johnny.restjaxrsjee8.dto;

public class BookDTO {

	private String isbn;
	private String name;
	private String author;
	private String year;
	private String genre;
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
