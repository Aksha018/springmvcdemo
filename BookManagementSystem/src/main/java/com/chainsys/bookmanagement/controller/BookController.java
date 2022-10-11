package com.chainsys.bookmanagement.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.bookmanagement.dao.BookDao;
import com.chainsys.bookmanagement.model.Books;

@Controller
@RequestMapping("/books")
public class BookController {
	
	 @Autowired
	   BookDao bookDao;
	    
	    @GetMapping("/addbookdetails")
		public String addbook() {
	    	System.out.println("Hello");
			return "/add-book.jsp";
		}
        
	    @GetMapping("add")
	    public String insertBook(@RequestParam("bookId")int bookId,@RequestParam("bookName")String bookName,@RequestParam("author")String author,@RequestParam("publishingYear")String publishingYear,@RequestParam("price")int price,@RequestParam("sellingDate")String sellingDate,Model model){
	    	
	    	
			LocalDate date = LocalDate.parse(sellingDate);
			Date sellingDate1 = Date.valueOf(date);
			
	    		Books book = new Books();
	    		book.setBookId(bookId);
	    		book.setBookName(bookName);
	    		book.setAuthor(author);
	    		book.setPublishingYear(publishingYear);
	    		book.setPrice(price);
	    		book.setSellingDate(sellingDate1);
	        	
	    		int addBooks = bookDao.addBooks(book);
	           
	    		List<Books> bookList = bookDao.bookList();
	    		 model.addAttribute("bookList", bookList);
	    		 return "/book-list.jsp";
	    }	    

}
