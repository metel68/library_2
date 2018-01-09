package models;

public class BookCategory {
	private Book book;
	private Category category;
	
	public BookCategory(Book book2, Category category) {
		this.book = book2;
		this.category = category;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
