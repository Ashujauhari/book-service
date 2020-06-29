package com.cognizant.book.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.book.BookServiceApplication;
import com.cognizant.book.dao.BookDaoImpl;
import com.cognizant.book.entity.Book;
import com.cognizant.book.exception.BookNotFoundException;

@Service
public class BookService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceApplication.class);
	
	@Autowired
	private BookDaoImpl bookDaoImpl;
	
	public List<Book> getAllBooks() {
		LOGGER.info("BookService public List<Book> getAllUsers() START");

		List<Book> listOfBooks = bookDaoImpl.getAllBooks();

		LOGGER.debug("List of All Books :{}", listOfBooks);
		LOGGER.info("BookService public List<Book> getAllUsers() END");
		return listOfBooks;
	}

	
	public Book getBookById(int id) {
		LOGGER.info("BookService public Book getBookById(int id)  START");

		Book book = bookDaoImpl.getBookById(id);

		LOGGER.debug("Book :{}", book);
		LOGGER.info("BookService public Book getBookById(int id)  END");
		return book;
	}

	
	public Book addBook(Book book) {

		LOGGER.info("BookService public Book addBook(Book book)  START");

		Book book_added = bookDaoImpl.addBook(book);

		LOGGER.debug("Book :{}", book_added);
		LOGGER.info("BookService public Book addBook(Book book)  END");
		return book_added;
	}

	
	public Book updateBookDetails(int id, Book bookDetails) {
		LOGGER.info("BookService public Book updateBookDetails(int id, Book bookDetails)  START");

		Book book = bookDaoImpl.updateBookDetails(id, bookDetails); 
		LOGGER.debug("Book :{}", book);
		LOGGER.info("BookService public Book updateBookDetails(int id, Book bookDetails)  END");
		return book;
	}

	
	public void deleteBook(int id) {
		LOGGER.info("BookService public void deleteBook(int id)  START");
		
		bookDaoImpl.deleteBook(id);
		
		LOGGER.info("BookService public void deleteBook(int id)  END");
	}
}
