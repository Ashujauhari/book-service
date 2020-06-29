package com.cognizant.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="book")
@Data
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="title",nullable=false)
	private String title;
	@Column(name="author",nullable=false)
	private String author;
	@Column(name="price",nullable=false)
	private double price;
}
