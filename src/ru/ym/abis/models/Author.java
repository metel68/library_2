package ru.ym.abis.models;

public class Author {
	private int id;
	private String fullName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFull_name() {
		return fullName;
	}
	public void setFull_name(String full_name) {
		this.fullName = full_name;
	}
	
	public Author() {
		
	}
	public Author(int id, String full_name) {
		super();
		this.id = id;
		this.fullName = full_name;
	}
	
}
