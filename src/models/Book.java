package models;

import java.sql.Date;
import java.util.List;

public class Book {
	private int id;
	private String isbn;
	private String title;
	private List<Author> authors;
	private Publisher publisher;
	private int year;
	private int count;
	private String description;
	private Date addedAt;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getAddedAt() {
		return addedAt;
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
