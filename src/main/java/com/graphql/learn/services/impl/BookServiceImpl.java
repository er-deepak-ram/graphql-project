package com.graphql.learn.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.learn.entities.Book;
import com.graphql.learn.repositories.BookRepository;
import com.graphql.learn.services.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book create(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book get(int bookId) {
		return bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book you are looking for not found in server!"));
	}

}
