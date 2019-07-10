package com.revature;

import java.io.PrintWriter;
import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.models.Book;
import com.revature.services.Library;

public class Driver {

	public static void main(String[] args) {
		String libraryServiceUrl = "http://localhost:8080/LibrarySoapService/library?wsdl";
		
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress(libraryServiceUrl);
		factory.setServiceClass(Library.class);
		
		LoggingInInterceptor inInterceptor = new LoggingInInterceptor();
		LoggingOutInterceptor outInterceptor = new LoggingOutInterceptor();	
		
		factory.getInInterceptors().add(inInterceptor);
		factory.getOutInterceptors().add(outInterceptor);
		
		inInterceptor.setPrintWriter(new PrintWriter(System.out));
		outInterceptor.setPrintWriter(new PrintWriter(System.out));

		Library library = (Library) factory.create();
		
		
		String result = library.addBook(new Book(5, "House of the Scorpion", "Nancy Farmer",2002));
		System.out.println(result);
		
		List<Book> books = library.getAllBooks();
		for(Book b: books) {
			System.out.println(b);
		}
	}

}
