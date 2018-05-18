package models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.Expose;

public class Book {
	@Expose
	private int id;
	@Expose
	private String isbn;
	@Expose
	private String title;
	@Expose
	private List<Author> authors = new ArrayList<>();
	private List<Category> categories = new ArrayList<>();
	@Expose
	private Publisher publisher;
	@Expose
	private int year;
	@Expose
	private int count;
	@Expose
	private int size;
	@Expose
	private String description;
	@Expose
	private Date addedAt;
	@Expose
	private String cover;
	@Expose
	private Timestamp date;
	
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
	
	public Book(int id, String isbn, String title, List<Author> authors, Publisher publisher, int year, int count,
			int size, String description, Date addedAt) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.authors = authors;
		this.publisher = publisher;
		this.year = year;
		this.count = count;
		this.size = size;
		this.description = description;
		this.addedAt = addedAt;
	}
	public Book(int id) {
		this.id = id;
	}
	public Book() {
		
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}
		
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
}
