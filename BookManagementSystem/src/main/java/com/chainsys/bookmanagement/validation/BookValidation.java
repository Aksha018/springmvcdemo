package com.chainsys.bookmanagement.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Repository;

import com.chainsys.bookmanagement.model.Books;

@Repository
public class BookValidation {
	
	
		
		public boolean chechBookId(int bookId) {
			if((bookId<=0)) {
				return false;
			}
			else {
				return true;
			}
		}
		public boolean checkBook(Books book) {
			if(book==null) {
				return false;
				
			}
			else {
				return true;
			}
		}

		 public boolean checkBookName(String bookName) {
			 String regex = "^[a-z A-Z]+$";
			 Pattern p = Pattern.compile(regex);
			 if(bookName==null) {
				 return false;
			 }
			 Matcher m = p.matcher(bookName);
			 return m.matches();
		 }
		 
		 public boolean checkAuthor(String author) {
			 String regex = "^[a-z A-Z]+$";
			 Pattern p = Pattern.compile(regex);
			 if(author==null) {
				 return false;
			 }
			 Matcher m = p.matcher(author);
			 return m.matches();
		 }
		 
		 public boolean checkPrice(int price) {
			   if((price<=0)) {
				   return false;
			   }
			   else {
				   return true;
			   }
		   }
		   
}
