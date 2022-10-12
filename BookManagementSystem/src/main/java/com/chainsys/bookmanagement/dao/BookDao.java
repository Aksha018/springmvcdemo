package com.chainsys.bookmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.bookmanagement.exception.BookException;
import com.chainsys.bookmanagement.mapper.BookMapper;
import com.chainsys.bookmanagement.model.Books;
import com.chainsys.bookmanagement.validation.BookValidation;

@Repository
public class BookDao {
     	@Autowired
	    JdbcTemplate jdbcTemplate;
     	@Autowired
     	BookValidation bookValidation;
	
// Insert
		public int addBooks(Books book) {
			String query = "insert into BOOKS(BOOK_ID,BOOK_NAME,AUTHOR,PUBLISHING_YEAR,PRICE,SELLING_DATE,BOOK_IMAGE)values(?,?,?,?,?,?,?)";
			int details = 0;
			Object[] bookDetail = { book.getBookId(),book.getBookName(),book.getAuthor(),book.getPublishingYear(),book.getPrice(),book.getSellingDate(),book.getBookImage()};
			details = jdbcTemplate.update(query, bookDetail);
			return details;
		}
//View user
		public List<Books> bookList(){
			String select = "SELECT BOOK_ID,BOOK_NAME,AUTHOR,PUBLISHING_YEAR,PRICE,SELLING_DATE,BOOK_IMAGE FROM BOOKS";
			List<Books> bookList = null;
			bookList = jdbcTemplate.query(select, new BookMapper());
			return bookList;
		}
//Update
		public int updateBooks(Books book) {
			String query = "update BOOKS set BOOK_NAME=?,AUTHOR=?,PUBLISHING_YEAR=?,PRICE=?,SELLING_DATE=?,BOOK_IMAGE=? where BOOK_ID=?";
			int details = 0;
			Object[] bookDetail = { book.getBookName(),book.getAuthor(),book.getPublishingYear(),book.getPrice(),book.getSellingDate(),book.getBookId()};
			details = jdbcTemplate.update(query, bookDetail);
			return details;
		}
//Delete		
		public int deleteBooks(int bookId) {
			String query ="delete from BOOKS where BOOK_ID=?";
			int details=0;
			details = jdbcTemplate.update(query,bookId);
			return details;
		}
//Find By Book Id		
		public Books findByBookId(int bookId)  throws BookException {
			if(!bookValidation.chechBookId(bookId)){
				throw new BookException("Invalid Book Id");
			}
			String select = "select BOOK_ID,BOOK_NAME,AUTHOR,PUBLISHING_YEAR,PRICE,SELLING_DATE,BOOK_IMAGE from BOOKS where BOOK_ID=?";
		     Books findByBookId = null;
		     findByBookId=jdbcTemplate.queryForObject(select, new BookMapper(),bookId);
		     if(!bookValidation.checkBook(findByBookId)) {
		    	 throw new BookException("Data not Found");
		     }
		     return findByBookId;
		}		
					
}


