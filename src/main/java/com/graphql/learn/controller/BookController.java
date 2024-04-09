package com.graphql.learn.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphql.learn.entities.Book;
import com.graphql.learn.model.BookInput;
import com.graphql.learn.services.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	
	@MutationMapping("createBook")
	public Book create(@Argument BookInput book) {
		Book b = new Book();
		BeanUtils.copyProperties(book, b);
//		b.setTitle(book.getTitle());
//		b.setDescription(book.getDescription());
//		b.setPrice(book.getPrice());
//		b.setAuthor(book.getAuthor());
//		b.setPages(book.getPages());
		return bookService.create(b);
	}
	
	@QueryMapping("allBooks")
	public List<Book> getAll() {
		return bookService.getAll();
	}
	
	@QueryMapping("getBook")
	public Book get(@Argument int bookId) {
		return bookService.get(bookId);
	}
}
