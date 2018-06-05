package com.mutistic.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookList")
public class BookController {
	
//	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	public BookController(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}



	@RequestMapping(value="/{findAll}", method=RequestMethod.GET)
	public String findAll(Model model) {
		List<BookEntity> readingList = bookRepository.findAll();
		if (readingList != null) {
			model.addAttribute("books", readingList);
		}
		return "bookList";
	}
	
	
}
