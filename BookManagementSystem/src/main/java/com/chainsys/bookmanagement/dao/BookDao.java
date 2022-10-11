package com.chainsys.bookmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.chainsys.bookmanagement.mapper.BookMapper;
import com.chainsys.bookmanagement.model.Books;

public class BookDao {
     	@Autowired
	    JdbcTemplate jdbcTemplate;
	
// Insert
		public int addBooks(Books book) {
			String query = "insert into BOOKS(BOOK_ID,BOOK_NAME,AUTHOR,PUBLISHING_YEAR,PRICE,SELLING_DATE)values(?,?,?,?,?,?)";
			int details = 0;
			Object[] bookDetail = { book.getBookId(),book.getBookName(),book.getAuthor(),book.getPublishingYear(),book.getPrice(),book.getSellingDate()};
			details = jdbcTemplate.update(query, bookDetail);
			return details;
		}
//View user
		public List<Books> bookList(){
			String select = "SELECT BOOK_ID,BOOK_NAME,AUTHOR,PUBLISHING_YEAR,PRICE,SELLING_DATE FROM BOOKS";
			List<Books> bookList = null;
			bookList = jdbcTemplate.query(select, new BookMapper());
			return bookList;
		}

}


