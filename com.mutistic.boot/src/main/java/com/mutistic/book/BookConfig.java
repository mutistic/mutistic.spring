package com.mutistic.book;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class BookConfig {

//	@Bean
	public BookEntity bookEntity() {
		return new BookEntity();
	}
}
