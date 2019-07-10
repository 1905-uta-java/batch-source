package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Book;

public class LibraryImpl implements Library {
	
	private List<Book> bookList = new ArrayList<>();
	
	public LibraryImpl() {
		super();
		bookList.add(new Book(1,"Of Mice And Men", "John Steinbeck", 1937));
		bookList.add(new Book(2, "Crime and Punishment", "Fyodor Dostoevsky", 1866));
		bookList.add(new Book(3,"Mrs. Dalloway", "Virginia Woolf", 1925));
		bookList.add(new Book(4, "House of Leaves", "Mark Z. Danielewski", 2000));
	}

	@Override
	public List<Book> getAllBooks() {
		System.out.println("getting all books");
		return new ArrayList<Book>(bookList);
	}

	@Override
	public String addBook(Book book) {
		for(Book b: bookList) {
			if (b.getId() == book.getId()) {
				throw new RuntimeException("Book has already been added!");
			}
		}
		bookList.add(book);
		System.out.println("adding: "+book.getName());
		return book.getName()+" has been added to the library";
	}

}
