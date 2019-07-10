package com.revature.models;

public class Book {
	
	private int id;
	private String name;
	private String author;
	private int year;

	public Book() {
		super();
	}
	
	public Book(int id, String name, String author, int year) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", year=" + year + "]";
	}
	
	

}
