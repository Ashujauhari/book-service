package com.cognizant.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.book.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
