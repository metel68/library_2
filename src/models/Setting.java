package models;

public class Setting {
	private int id;
	private int maxDuration;

	public int getMaxDuration() {
		return maxDuration;
	}

	public void setMaxDuration(int maxDuration) {
		this.maxDuration = maxDuration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Setting(int maxDuration) {
		super();
		this.maxDuration = maxDuration;
	}
	
	public Setting() {
	}
}
