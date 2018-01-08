package ru.ym.abis.models;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;

import com.google.gson.annotations.Expose;

public class User {
	@Expose(serialize = true, deserialize = false)
	private int id;

	@Expose
	private String username;

	@Expose(serialize = false, deserialize = true)
	private String password;

	@Expose
	private boolean isAdmin;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void hashPassword() {
		this.password = DigestUtils.sha256Hex(this.password.getBytes(StandardCharsets.UTF_8)).toString();
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (username == null) {
			if (other.getUsername() != null)
				return false;
		} else if (!username.equals(other.getUsername()))
			return false;
		if (password == null) {
			if (other.getPassword() != null)
				return false;
		} else if (!password.equals(other.getPassword()))
			return false;
		return true;
	}

	public User(int id, String username, String password, boolean isAdmin) {
		this();
		this.id = id;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return this.getId() + ": " + this.getUsername();
	}
}
