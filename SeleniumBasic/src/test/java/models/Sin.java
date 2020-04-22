package models;

import java.util.List;

import enumeratios.SinType;

public class Sin {

	private String title;
	private String author;
	private String message;
	private List<SinType> tags;
	private boolean forgiven;

	public Sin(String title, String author, String message) {
		this.setTitle(title);
		this.setAuthor(author);
		this.setMessage(message);
		this.forgiven = false;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public boolean isForgiven() {
		return forgiven;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<SinType> getTags() {
		return tags;
	}

	public void setTags(List<SinType> tags) {
		this.tags = tags;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setForgiven(boolean forgiven) {
		this.forgiven = forgiven;
	}
	

}
