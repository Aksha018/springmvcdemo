package com.chainsys.bookmanagement.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.chainsys.bookmanagement.dao.BookDao;
import com.chainsys.bookmanagement.exception.BookException;
import com.chainsys.bookmanagement.model.Books;
import com.chainsys.bookmanagement.validation.BookValidation;

@Controller
@RequestMapping("/books")
public class BookController {
	
	 @Autowired
	   BookDao bookDao;
     @Autowired
        BookValidation bookValidation;
	
	    @GetMapping("/addbookdetails")
		public String addbook() {
			return "/add-book.jsp";
		}
	    
	    @PostMapping("add")
	    public String insertBook(@RequestParam(name = "bookId", required = true)int bookId,@RequestParam("bookName")String bookName,@RequestParam("author")String author,@RequestParam("publishingYear")String publishingYear,@RequestParam("price")int price,@RequestParam("sellingDate")String sellingDate,@RequestParam("file") MultipartFile image,Model model){

	    	if(bookValidation.chechBookId(bookId)) {
	    	if(bookValidation.checkBookName(bookName)) {
	    		if(bookValidation.checkAuthor(author)) {
	    			if(bookValidation.checkPrice(price)) {
	    	
	    	String path = "C:\\Users\\aksh3106\\eclipse-workspace\\BookManagementSystem\\src\\main\\webapp\\images";
			String filename = image.getOriginalFilename();
	   
	    	FileInputStream fin = null;
			try {
				fin = new FileInputStream(path + filename);
			} catch (FileNotFoundException e) {
		
				e.printStackTrace();
			}
	    	byte[] images = null;
			try {
				images = fin.readAllBytes();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
	LocalDate date = LocalDate.parse(sellingDate);
	Date sellingDate1 = Date.valueOf(date);
	
		Books book = new Books();

		book.setBookId(bookId);
		book.setBookName(bookName);
		book.setAuthor(author);
		book.setPublishingYear(publishingYear);
		book.setPrice(price);
		book.setSellingDate(sellingDate1);
		book.setBookImage(images);
    	
		int addBooks = bookDao.addBooks(book);

		List<Books> bookList = bookDao.bookList();
		 model.addAttribute("bookList", bookList);
		 return "/book-list.jsp";
		 
	}else {
		String addPrice = "Please enter valid number";
		model.addAttribute("check", addPrice);
		return "/add-book.jsp";
	}
		}else {
			String authorName = "Please Enter Alphabets only";
			model.addAttribute("check", authorName);
			return "/add-book.jsp";
		}
	}else {
		String addBookName = "Please Enter Alphabets only";
		model.addAttribute("check", addBookName);
		return "/add-book.jsp";
		
	}
}else {
	String addBookId ="Please enter valid id";
	model.addAttribute("check", addBookId);
	return "/add-book.jsp";
}	
		 
}
			    
	    @GetMapping("/updatebookdetails")
		public String updatebook() {
			return "/update-book.jsp";
		}
	    @GetMapping("update")
	    public String updateBook(@RequestParam("bookId")int bookId,@RequestParam("bookName")String bookName,@RequestParam("author")String author,@RequestParam("publishingYear")String publishingYear,@RequestParam("price")int price,@RequestParam("sellingDate")String sellingDate,Model model){
	    	if(bookValidation.chechBookId(bookId)) {
	    	if(bookValidation.checkBookName(bookName)) {
	    		if(bookValidation.checkAuthor(author)) {
	    			if(bookValidation.checkPrice(price)) {
	    	
	    	LocalDate date = LocalDate.parse(sellingDate);
			Date sellingDate1 = Date.valueOf(date);
			
	    		Books book = new Books();
	    		book.setBookId(bookId);
	    		book.setBookName(bookName);
	    		book.setAuthor(author);
	    		book.setPublishingYear(publishingYear);
	    		book.setPrice(price);
	    		book.setSellingDate(sellingDate1);
	    
	    
	    		int updateBooks = bookDao.updateBooks(book);
		           
	    		List<Books> bookList = bookDao.bookList();
	    		 model.addAttribute("bookList", bookList);
	    		 return "/book-list.jsp";
	    			}else {
	    			String addPrice = "Please enter valid number";
	    			model.addAttribute("check", addPrice);
	    			return "/update-book.jsp";
	    		}
	    			}else {
	    				String authorName = "Please Enter Alphabets only";
	    				model.addAttribute("check", authorName);
	    				return "/update-book.jsp";
	    			}
	    		}else {
	    			String addBookName = "Please Enter Alphabets only";
	    			model.addAttribute("check", addBookName);
	    			return "/update-book.jsp";
	    			
	    		}
	    	}else {
	    		String addBookId ="Please enter valid id";
	    		model.addAttribute("check", addBookId);
	    		return "/update-book.jsp";
	    	}	
	    			 
	    }
	    
	    @GetMapping("deletebookdetails")
	    public String delete() {
	    	return "/delete-book.jsp";
	    }
	    @GetMapping("delete")
	    public String deleteBook(@RequestParam("bookId")int bookId,Model model) {
	    if(bookValidation.chechBookId(bookId)) {
	    	int deletebook = bookDao.deleteBooks(bookId);
	    	List<Books> bookList = bookDao.bookList();
   		 model.addAttribute("bookList", bookList);
   		 return "/book-list.jsp";
   		}else {
   			String addBookId ="Please enter valid id";
   			model.addAttribute("check", addBookId);
   			return "/delete-book.jsp";
   		}	
	    }   	
	    
	    @GetMapping("/findBybookId")
	    public String find() {
	    	return "/findby-id.jsp";
	    }
	    
	    @GetMapping("find")
	    public String findByBookIds(@RequestParam("bookId")int bookId,Model model) {
	    	Books findByBookId;
	    try {
	    	Books book = bookDao.findByBookId(bookId);
	    	List<Books> bookList = new ArrayList<>();
	    	bookList.add(book);
	    	model.addAttribute("bookList", bookList);
	    	return "/book-list.jsp";
	    	
	    }catch(BookException e) {
	    	return null;
	    }
   
 }
}
