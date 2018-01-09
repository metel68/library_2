package models;

public class Category {
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String full_name) {
		this.name = full_name;
	}
	
	public Category() {
		
	}
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
