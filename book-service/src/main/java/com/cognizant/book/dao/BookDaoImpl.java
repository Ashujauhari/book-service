package com.cognizant.book.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.book.BookServiceApplication;
import com.cognizant.book.entity.Book;
import com.cognizant.book.exception.BookNotFoundException;
import com.cognizant.book.repository.BookRepository;

@Service
@Transactional
public class BookDaoImpl implements BookDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceApplication.class);

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		LOGGER.info("BookDaoImpl public List<Book> getAllUsers() START");

		List<Book> listOfBooks = bookRepository.findAll();

		LOGGER.debug("List of All Books :{}", listOfBooks);
		LOGGER.info("BookDaoImpl public List<Book> getAllUsers() END");
		return listOfBooks;
	}

	@Override
	public Book getBookById(int id) {
		LOGGER.info("BookDaoImpl public Book getBookById(int id)  START");

		Book book = bookRepository.findById(id).orElseThrow(()-> {throw new BookNotFoundException();});

		LOGGER.debug("Book :{}", book);
		LOGGER.info("BookDaoImpl public Book getBookById(int id)  END");
		return book;
	}

	@Override
	public Book addBook(Book book) {

		LOGGER.info("BookDaoImpl public Book addBook(Book book)  START");

		Book book_added = bookRepository.save(book);

		LOGGER.debug("Book :{}", book_added);
		LOGGER.info("BookDaoImpl public Book addBook(Book book)  END");
		return book_added;
	}

	@Override
	public Book updateBookDetails(int id, Book bookDetails) {
		LOGGER.info("BookDaoImpl public Book updateBookDetails(int id, Book bookDetails)  START");

		Book book = bookRepository.findById(id).orElseThrow(()-> {throw new BookNotFoundException();});
		book.setAuthor(bookDetails.getAuthor());
		book.setPrice(bookDetails.getPrice());
		book.setTitle(bookDetails.getTitle());
		
		final Book updatedBook = bookRepository.save(book);
		
		LOGGER.debug("Book :{}", updatedBook);
		LOGGER.info("BookDaoImpl public Book updateBookDetails(int id, Book bookDetails)  END");
		return updatedBook;
	}

	@Override
	public void deleteBook(int id) {
		LOGGER.info("BookDaoImpl public void deleteBook(int id)  START");
		Book book = bookRepository.findById(id).orElseThrow(()-> {throw new BookNotFoundException();});
		bookRepository.delete(book);
		LOGGER.info("BookDaoImpl public void deleteBook(int id)  END");
	}

}
