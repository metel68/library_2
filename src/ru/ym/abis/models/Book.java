package ru.ym.abis.models;

import java.util.Date;
import java.util.List;

public class Book {
	private int id;
	private String isbn;
	private String title;
	private List<Author> authors;
	private Publisher publisher;
	private int year;
	private int count;
	private int size;
	private String description;
	private Date addedAt;
	
	public int getId() {
		return id;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getTitle() {
		return title;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public int getYear() {
		return year;
	}
	public int getCount() {
		return count;
	}
	public int getSize() {
		return size;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getAddedAt() {
		return addedAt;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void setAddedAt(Date addedAt) {
		this.addedAt = addedAt;
	}
	public Book(int id, String isbn, String title, List<Author> authors, Publisher publisher, int year, int count) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.authors = authors;
		this.publisher = publisher;
		this.year = year;
		this.count = count;
	} 
	public Book() {
		
	}
		
}
