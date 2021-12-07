package com.ynov.b3info.eval.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Livre {

	protected Integer id;
	private String title;
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
	
	public String title() {
		return title;
	}
	
	public void settitle(String title) {
		this.title = title;
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
