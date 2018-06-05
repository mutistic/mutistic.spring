package com.mutistic.book;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Resource
	private BookRepository bookRepository;
	
	public List<BookEntity> findAll(){
		return bookRepository.findAll();
	}
	
}
