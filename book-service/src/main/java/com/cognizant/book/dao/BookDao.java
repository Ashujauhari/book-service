package com.cognizant.book.dao;

import java.util.List;

import com.cognizant.book.entity.Book;

public interface BookDao {

	public List<Book> getAllBooks();
	public Book getBookById(int id);
	public Book addBook(Book book);
	public Book updateBookDetails(int id, Book bookDetails);
	public void deleteBook(int id);
}
