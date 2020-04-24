package com.example.expertisetestoutline.request;

public class BookStoreRequest {
	
	private String category;
	
	private String title;
	
	private int year;
	
	private float price;
	
	private AuthorsRequest authors;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public AuthorsRequest getAuthors() {
		return authors;
	}

	public void setAuthors(AuthorsRequest authors) {
		this.authors = authors;
	}
	
	
	

}
