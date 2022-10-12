package com.chainsys.bookmanagement.model;

import java.sql.Date;

public class Books {
	
	private int bookId;
	private String bookName;
	private String author;
	private int price;
	private Date sellingDate;
	private String publishingYear;
	private byte[] bookImage;
    private String imagesPath;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getSellingDate() {
		return sellingDate;
	}
	public void setSellingDate(Date sellingDate) {
		this.sellingDate = sellingDate;
	}
	public String getPublishingYear() {
		return publishingYear;
	}
	public void setPublishingYear(String publishingYear) {
		this.publishingYear = publishingYear;
	}
	public byte[] getBookImage() {
		return bookImage;
	}
	public void setBookImage(byte[] bookImage) {
		this.bookImage = bookImage;
	}
	public String getImagesPath() {
		return imagesPath;
	}
	public void setImagesPath(String imagesPath) {
		this.imagesPath = imagesPath;
	}
	
}
