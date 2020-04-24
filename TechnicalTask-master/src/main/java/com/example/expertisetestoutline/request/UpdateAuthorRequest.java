package com.example.expertisetestoutline.request;

import java.util.List;

public class UpdateAuthorRequest {
	
	
	private Long id;
	
	private List<String> author;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getAuthor() {
		return author;
	}

	public void setAuthor(List<String> author) {
		this.author = author;
	}
	
	

}
