package com.graphql.learn.services;

import java.util.List;

import com.graphql.learn.entities.Book;

public interface BookService {

	Book create(Book book);
	
	List<Book> getAll();
	
	Book get(int bookId);
}
