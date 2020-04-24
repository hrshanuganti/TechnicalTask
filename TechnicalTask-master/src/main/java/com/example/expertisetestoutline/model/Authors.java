package com.example.expertisetestoutline.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "authors")
@XmlAccessorType(XmlAccessType.PROPERTY)
@Entity
@Table(name = "AUTHORS")
public class Authors  {
	
	
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "author")
	@ElementCollection(targetClass=String.class)
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
