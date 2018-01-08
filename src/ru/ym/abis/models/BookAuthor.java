package ru.ym.abis.models;

public class BookAuthor {
	private Book book;
	private Author author;
	
	public BookAuthor(Book book2, Author author2) {
		this.book = book2;
		this.author = author2;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
}
