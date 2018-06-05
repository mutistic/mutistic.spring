package com.mutistic.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mutistic.book.BookEntity;
import com.mutistic.book.BookService;

@RestController
@RequestMapping("/bookList")
public class BookController {
	
	@Resource
	private BookService bookService;
	
//	@Autowired
//	public BookController(BookRepository bookRepository) {
//		super();
//		this.bookRepository = bookRepository;
//	}



	@RequestMapping(value="/{findAll}", method=RequestMethod.GET)
	public String findAll(Model model) {
		List<BookEntity> readingList = bookService.findAll();
		if (readingList != null) {
			model.addAttribute("books", readingList);
		}
		return "bookList";
	}
	
	
}
