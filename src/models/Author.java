package models;

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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + id;
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
		Author other = (Author) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
