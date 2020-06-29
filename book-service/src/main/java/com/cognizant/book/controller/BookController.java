package com.cognizant.book.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.book.entity.Book;
import com.cognizant.book.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON)
	public List<Book> getAllBooks()
	{
		List<Book> books = bookService.getAllBooks();
		return books;
	}
	
	@GetMapping(value ="/{id}",produces = MediaType.APPLICATION_JSON)
	public Book getBookById(@PathVariable @Valid int id)
	{
		return bookService.getBookById(id);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON)
	public Book addBook(@RequestBody Book book)
	{
		return bookService.addBook(book);
	}
	
	@PutMapping(value="/{id}",produces = MediaType.APPLICATION_JSON)
	public Book updateBookDetails(@PathVariable int id, @RequestBody Book bookDetails)
	{
		return bookService.updateBookDetails(id, bookDetails);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable int id)
	{
		bookService.deleteBook(id);
	}
}
