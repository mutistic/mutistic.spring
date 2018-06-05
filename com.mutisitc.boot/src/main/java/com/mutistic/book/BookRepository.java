package com.mutistic.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


/**
 * @program 图书接口
 * @description service
 * @author mutisitic
 * @date 2018年6月4日
 */
@Component
public interface BookRepository extends JpaRepository<BookEntity, Long> {
	
	
}
