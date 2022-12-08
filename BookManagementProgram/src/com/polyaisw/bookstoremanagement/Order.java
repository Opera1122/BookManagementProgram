package com.polyaisw.bookstoremanagement;

public class Order {
	private int orderId;
	private int custId;
	private int bookId;
	private int salePrice;
	private String orderDate;
	
	public Order(int orderid, int custid, int bookid, int saleprice, String orderdate) {
		super();
		this.orderId = orderid;
		this.custId = custid;
		this.bookId = bookid;
		this.salePrice = saleprice;
		this.orderDate = orderdate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderid) {
		this.orderId = orderid;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custid) {
		this.custId = custid;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookid) {
		this.bookId = bookid;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int saleprice) {
		this.salePrice = saleprice;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderdate) {
		this.orderDate = orderdate;
	}
	
	
}
