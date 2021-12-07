package com.ynov.b3info.eval.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Livres {
	
	protected Integer id;
	private String book;
	private String releaseDate;
	private String author;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
	return id;
	}

	public void setId(Integer id) {
	this.id = id;
	}
	
	public String book() {
		return book;
	}
	
	public void setbook(String book) {
		this.book = book;
	}
	
	public String releaseDate() {
		return releaseDate;
	}
	
	public void setauthor(String author) {
		this.author = author;
	}
	
	public String author() {
		return author;
	}
	

}
