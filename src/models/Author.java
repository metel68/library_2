package models;

public class Author {
	private int id;
	private String full_name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	
	public Author() {
		
	}
	public Author(int id, String full_name) {
		super();
		this.id = id;
		this.full_name = full_name;
	}
	
}
