package com.polyaisw.bookstoremanagement;

public class Book {
	private int bookId;
	private String bookName;
	private String publisher;
	private int price;
	
	public Book(int bookid, String bookname, String publisher, int price) {
		super();
		this.bookId = bookid;
		this.bookName = bookname;
		this.publisher = publisher;
		this.price = price;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookid) {
		this.bookId = bookid;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookname) {
		this.bookName = bookname;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
