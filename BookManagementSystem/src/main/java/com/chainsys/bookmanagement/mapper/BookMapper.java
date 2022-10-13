package com.chainsys.bookmanagement.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.bookmanagement.model.Books;

	public class BookMapper implements RowMapper<Books>{
		@Override
		public Books mapRow(ResultSet rs,int rowNum)throws SQLException{
			
			int bookId=rs.getInt(1);
			String bookName = rs.getString(2);
			String author = rs.getString(3);
			String publishingYear = rs.getString(4);
			int price = rs.getInt(5);
			Date sellingDate = rs.getDate(6);
			byte[] images = rs.getBytes("BOOK_IMAGE");
			String base64Image = Base64.getEncoder().encodeToString(images);
			
			Books book = new Books();
			
			book.setBookId(bookId);
			book.setBookName(bookName);
			book.setAuthor(author);
			book.setPublishingYear(publishingYear);
			book.setPrice(price);
			book.setSellingDate(sellingDate);
			book.setBookImage(images);
	        book.setImagesPath(base64Image);
			
			return book;
			
		}

	}


