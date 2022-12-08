package com.polyaisw.bookstoremanagement;

public class Customer {
	private int custId;
	private String name;
	private String address;
	private String phone;
	
	public Customer(int custid, String name, String address, String phone) {
		super();
		this.custId = custid;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custid) {
		this.custId = custid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
