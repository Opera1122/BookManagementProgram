package com.polyaisw.bookstoremanagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class BookStore extends JFrame {
	static Book book = new Book(0, null, null, 0);
	static Customer customer = new Customer(0, null, null, null);
	static Order order = new Order(0, 0, 0, 0, null);
	
	JPanel panel1 = new JPanel();
	
	JPanel bookInputPanel = new JPanel();
	JPanel bookEditPanel = new JPanel();
	
	JPanel customerInputPanel = new JPanel();
	JPanel customerEditPanel = new JPanel();
	
	JPanel orderInputPanel = new JPanel();
	JPanel orderEditPanel = new JPanel();
	
	JTextField bookNumTextField = new JTextField(10);
	JTextField bookNameTextField = new JTextField(10);
	JTextField bookPublisherTextField = new JTextField(10);
	JTextField bookPriceTextField = new JTextField(10);
	
	JTextField bookNameUpdateTextField = new JTextField(10);
	JTextField bookPriceUpdateTextField = new JTextField(10);
	JLabel stateBookNameLabel = new JLabel("������ : ");
	JLabel stateBookPriceLabel = new JLabel("������ ���� : ");
	JButton bookUpdateCheckButton = new JButton("Ȯ��");

	JLabel stateBookNameLabel2 = new JLabel("������ : ");
	JTextField bookDeleteTextField = new JTextField(10);
	JButton bookDeleteCheckButton = new JButton("Ȯ��");
	
	JTextField customerNumTextField = new JTextField(10);
	JTextField customerNameTextField = new JTextField(10);
	JTextField customerAddressTextField = new JTextField(10);
	JTextField customerPhoneTextField = new JTextField(10);
	
	//�� ����ĭ
	JTextField customerNumUpdateTextField = new JTextField(10);
	JTextField customerNameUpdateTextField = new JTextField(10);
	JTextField customerAddressUpdateTextField = new JTextField(10);
	JTextField customerPhoneUpdateTextField = new JTextField(10);
	JButton stateCustomerNameButton = new JButton("����");
	JButton stateCustomerAddressButton = new JButton("�ּ�");
	JButton stateCustomerPhoneButton = new JButton("�޴���ȭ");
	JLabel customerNumUpdateLabel = new JLabel("�� ��ȣ : ");
	JLabel stateCustomerNameLabel = new JLabel("���� : ");
	JLabel stateCustomerAddressLabel = new JLabel("�ּ� : ");
	JLabel stateCustomerPhoneLabel = new JLabel("�޴���ȭ : ");
	JButton customerNameUpdateCheckButton = new JButton("Ȯ��");
	JButton customerAddressUpdateCheckButton = new JButton("Ȯ��");
	JButton customerPhoneUpdateCheckButton = new JButton("Ȯ��");

	JLabel stateCustomerNameLabel2 = new JLabel("���� : ");
	JTextField customerDeleteTextField = new JTextField(10);
	JButton customerDeleteCheckButton = new JButton("Ȯ��");
	
	JTextField orderNumTextField = new JTextField(10);
	JTextField orderCustomerNumTextField = new JTextField(10);
	JTextField orderBookNumTextField = new JTextField(10);
	JTextField orderBookPriceTextField = new JTextField(10);
	JTextField orderDateTextField = new JTextField(10);
	
	JLabel stateOrderNumLabel = new JLabel("�ֹ� ��ȣ : ");
	JTextField orderDeleteTextField = new JTextField(10);
	JButton orderDeleteCheckButton = new JButton("Ȯ��");
	
	JButton bookButton = new JButton("��������");
	JButton customerButton = new JButton("������");
	JButton orderButton = new JButton("�ֹ��ϱ�");
	
	JButton bookAddButton = new JButton("�߰�");
	JButton bookUpdateButton = new JButton("���� ����");
	JButton bookDeleteButton = new JButton("����");
	JButton bookShowListButton = new JButton("����Ʈ ����");
	
	JButton customerAddButton = new JButton("�߰�");
	JButton customerUpdateButton = new JButton("����");
	JButton customerDeleteButton = new JButton("����");
	JButton customerShowListButton = new JButton("����Ʈ ����");
	
	JButton orderAddButton = new JButton("�߰�");
	JButton orderDeleteButton = new JButton("����");
	JButton orderShowListButton = new JButton("����Ʈ ����");
	
	JLabel bookNumLabel = new JLabel("��ȣ");
	JLabel bookNameLabel = new JLabel("������");
	JLabel bookPublisherLabel = new JLabel("���ǻ�");
	JLabel bookPriceLabel = new JLabel("����");
	
	JLabel customerNumLabel = new JLabel("��ȣ");
	JLabel customerNameLabel = new JLabel("����");
	JLabel customerAddressLabel = new JLabel("�ּ�");
	JLabel customerPhoneLabel = new JLabel("�޴���ȭ");
	
	JLabel orderNumLabel = new JLabel("��ȣ");
	JLabel orderCustomerNumLabel = new JLabel("����ȣ");
	JLabel orderBookNumLabel = new JLabel("������ȣ");
	JLabel orderBookPriceLabel = new JLabel("��������");
	JLabel orderDateLabel = new JLabel("�ֹ���¥");
	
	LineBorder border = new LineBorder(Color.black);
	JPanel statePanel = new JPanel();
	JPanel statePanel2 = new JPanel();
	JLabel stateLabel = new JLabel();
	JLabel customerStateLabel = new JLabel("���� ������ �޴��Դϴ�.");
	
	//�������� ����, ����â
	public void StateBookUpdateSetVisibleTrue() {
		stateBookNameLabel.setVisible(true);
		bookNameUpdateTextField.setVisible(true);
		
		stateBookPriceLabel.setVisible(true);
		bookPriceUpdateTextField.setVisible(true);
		
		bookUpdateCheckButton.setVisible(true);
	}
	
	public void StateBookUpdateSetVisibleFalse() {
		stateBookNameLabel.setVisible(false);
		bookNameUpdateTextField.setVisible(false);
		
		stateBookPriceLabel.setVisible(false);
		bookPriceUpdateTextField.setVisible(false);
		
		bookUpdateCheckButton.setVisible(false);
	}
	
	public void StateBookDeleteSetVisibleTrue() {
		stateBookNameLabel2.setVisible(true);
		bookDeleteTextField.setVisible(true);
		
		bookDeleteCheckButton.setVisible(true);
	}
	
	public void StateBookDeleteSetVisibleFalse() {
		stateBookNameLabel2.setVisible(false);
		bookDeleteTextField.setVisible(false);
		
		bookDeleteCheckButton.setVisible(false);
	}
	
	//������ ����, ����â
	public void StateCustomerUpdateSetVisibleTrue() {
		stateCustomerNameButton.setVisible(true);
		stateCustomerAddressButton.setVisible(true);
		stateCustomerPhoneButton.setVisible(true);
	}
	
	public void StateCustomerUpdateSetVisibleFalse() {
		stateCustomerNameButton.setVisible(false);
		stateCustomerAddressButton.setVisible(false);
		stateCustomerPhoneButton.setVisible(false);
	}
	
	//�� �̸�
	public void StateCustomerNameUpdateSetVisibleTrue() {
		customerNumUpdateLabel.setVisible(true);
		customerNumUpdateTextField.setVisible(true);
		stateCustomerNameLabel.setVisible(true);
		customerNameUpdateTextField.setVisible(true);
		
		customerNameUpdateCheckButton.setVisible(true);
	}
	
	public void StateCustomerNameUpdateSetVisibleFalse() {
		customerNumUpdateLabel.setVisible(false);
		customerNumUpdateTextField.setVisible(false);
		stateCustomerNameLabel.setVisible(false);
		customerNameUpdateTextField.setVisible(false);
		
		customerNameUpdateCheckButton.setVisible(false);
	}
	
	//�� �ּ�
	public void StateCustomerAddressUpdateSetVisibleTrue() {
		customerNumUpdateLabel.setVisible(true);
		customerNumUpdateTextField.setVisible(true);
		stateCustomerAddressLabel.setVisible(true);
		customerAddressUpdateTextField.setVisible(true);
		
		customerAddressUpdateCheckButton.setVisible(true);
	}
	
	public void StateCustomerAddressUpdateSetVisibleFalse() {
		customerNumUpdateLabel.setVisible(false);
		customerNumUpdateTextField.setVisible(false);
		stateCustomerAddressLabel.setVisible(false);
		customerAddressUpdateTextField.setVisible(false);
		
		customerAddressUpdateCheckButton.setVisible(false);
	}
	
	//�� �޴���ȭ
	public void StateCustomerPhoneUpdateSetVisibleTrue() {
		customerNumUpdateLabel.setVisible(true);
		customerNumUpdateTextField.setVisible(true);
		stateCustomerPhoneLabel.setVisible(true);
		customerPhoneUpdateTextField.setVisible(true);
		
		customerPhoneUpdateCheckButton.setVisible(true);
	}
	
	public void StateCustomerPhoneUpdateSetVisibleFalse() {
		customerNumUpdateLabel.setVisible(false);
		customerNumUpdateTextField.setVisible(false);
		stateCustomerPhoneLabel.setVisible(false);
		customerPhoneUpdateTextField.setVisible(false);
		
		customerPhoneUpdateCheckButton.setVisible(false);
	}
	
	//�� ����
	public void StateCustomerDeleteSetVisibleTrue() {
		stateCustomerNameLabel2.setVisible(true);
		customerDeleteTextField.setVisible(true);
		
		customerDeleteCheckButton.setVisible(true);
	}
	
	public void StateCustomerDeleteSetVisibleFalse() {
		stateCustomerNameLabel2.setVisible(false);
		customerDeleteTextField.setVisible(false);
		
		customerDeleteCheckButton.setVisible(false);
	}
	
	//�ֹ����� ����â
	public void StateOrderDeleteSetVisibleTrue() {
		stateOrderNumLabel.setVisible(true);
		orderDeleteTextField.setVisible(true);
		
		orderDeleteCheckButton.setVisible(true);
	}
		
	public void StateOrderDeleteSetVisibleFalse() {
		stateOrderNumLabel.setVisible(false);
		orderDeleteTextField.setVisible(false);
		
		orderDeleteCheckButton.setVisible(false);
	}
	
	public static Connection makeConnection() {
		Connection con = null;
		
		try {
			// 1. ����̹� �ε�
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. ���ᰴü �����
			String url="jdbc:mysql://localhost:3306/bookstoredb?serverTimezone=Asia/Seoul ";
			String userid="root";
			String password="1234";
			
			con = DriverManager.getConnection(url, userid, password);
//			System.out.println("���� ����");
//			
//			con.close();
//			System.out.println("���� ����");
			
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
		
		return con;
	}
	
	public void insertBook(Book book) {
		Connection con = makeConnection();
		
		String sql="insert into book values(?, ?, ?, ?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			book.setBookId(Integer.parseInt(bookNumTextField.getText()));
			pstmt.setInt(1, book.getBookId());
			book.setBookName(bookNameTextField.getText());
			pstmt.setString(2, book.getBookName());
			book.setPublisher(bookPublisherTextField.getText());
			pstmt.setString(3, book.getPublisher());
			book.setPrice(Integer.parseInt(bookPriceTextField.getText()));
			pstmt.setInt(4, book.getPrice());
			
			int row = pstmt.executeUpdate();
			
			if (row==1)
				stateLabel.setText("�߰� ����");
			else
				stateLabel.setText("�߰� ����");
			
			pstmt.close();
			con.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void updateBookPrice(Book book) {
		Connection con = makeConnection();
		
		String sql="update book set price=? where bookname=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			book.setBookName(bookNameUpdateTextField.getText());
			pstmt.setString(2, book.getBookName());
			book.setPrice(Integer.parseInt(bookPriceUpdateTextField.getText()));
			pstmt.setInt(1, book.getPrice());
			
			int row = pstmt.executeUpdate();
			
			if (row==1)
				stateLabel.setText("���� ����");
			else
				stateLabel.setText("����");
			
			pstmt.close();
			con.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void deleteBook(Book book) {
		Connection con = makeConnection();
		
		String sql="delete from book where bookname=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			book.setBookName(bookDeleteTextField.getText());
			pstmt.setString(1, book.getBookName());
			
			int row = pstmt.executeUpdate();
			
			if (row==1)
				stateLabel.setText("���� ����");
			else
				stateLabel.setText("����");
			
			pstmt.close();
			con.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void showBookList() throws SQLException, IOException, RuntimeException {
		Connection con = makeConnection();
		
		String file_path = "D:\\";
		Workbook xworkbook = new SXSSFWorkbook();
		Sheet xSheet = xworkbook.createSheet("sheet1");
		Row xRow = null;
		Cell xCell = null;
		
		String sql = "select * from bookstoredb.book";
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		//���� ����
		File file = new File(file_path + "Book.xlsx");
		FileOutputStream fos = new FileOutputStream(file);

		//ù �� �Է�
		xRow = xSheet.createRow(0);
		xCell = xRow.createCell(0);
		xCell.setCellValue("���� ��ȣ");
		xCell = xRow.createCell(1);
		xCell.setCellValue("������");
		xCell = xRow.createCell(2);
		xCell.setCellValue("���ǻ�");
		xCell = xRow.createCell(3);
		xCell.setCellValue("����");
		xCell = xRow.createCell(4);
		
		int row = 1;
		
		while(rs.next()) {
			// quary ������� ������ ��������
			int bookId = rs.getInt(1);
			String bookName = rs.getString(2);
			String publisher = rs.getString(3);
			int price = rs.getInt(4);

			// ������ �Է�
			xRow = xSheet.createRow(row);
			xCell = xRow.createCell(0);
			xCell.setCellValue(bookId);
			xCell = xRow.createCell(1);
			xCell.setCellValue(bookName);
			xCell = xRow.createCell(2);
			xCell.setCellValue(publisher);
			xCell = xRow.createCell(3);
			xCell.setCellValue(price);
			
			row++;
		}
		rs.close();
		stmt.close();
		con.close();
		
		xworkbook.write(fos);
		if(fos != null) {
			fos.close();
		}
	}
	
	public void insertCustomer (Customer customer) {
		Connection con = makeConnection();
		
		String sql="insert into customer values(?, ?, ?, ?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			customer.setCustId(Integer.parseInt(customerNumTextField.getText()));
			pstmt.setInt(1, customer.getCustId());
			customer.setName(customerNameTextField.getText());
			pstmt.setString(2, customer.getName());
			customer.setAddress(customerAddressTextField.getText());
			pstmt.setString(3, customer.getAddress());
			customer.setPhone(customerPhoneTextField.getText());
			pstmt.setString(4, customer.getPhone());
			
			int row = pstmt.executeUpdate();
			
			if (row==1)
				stateLabel.setText("�߰� ����");
			else
				stateLabel.setText("�߰� ����");
			
			pstmt.close();
			con.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void updateCustomerName (Customer customer) {
		Connection con = makeConnection();
		
		String sql = "update customer set name=? where custid=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			customer.setName(customerNameUpdateTextField.getText());
			pstmt.setString(1, customer.getName());
			customer.setCustId(Integer.parseInt(customerNumUpdateTextField.getText()));
			pstmt.setInt(2, customer.getCustId());
			
			int row = pstmt.executeUpdate();
			
			if (row==1)
				stateLabel.setText("���� ����");
			else
				stateLabel.setText("���� ����");
			
			pstmt.close();
			con.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void updateCustomerAddress (Customer customer) {
		Connection con = makeConnection();
		
		String sql = "update customer set address=? where custid=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			customer.setAddress(customerAddressUpdateTextField.getText());
			pstmt.setString(1, customer.getAddress());
			customer.setCustId(Integer.parseInt(customerNumUpdateTextField.getText()));
			pstmt.setInt(2, customer.getCustId());
			
			int row = pstmt.executeUpdate();
			
			if (row==1)
				stateLabel.setText("���� ����");
			else
				stateLabel.setText("���� ����");
			
			pstmt.close();
			con.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void updateCustomerPhone (Customer customer) {
		Connection con = makeConnection();
		
		String sql = "update customer set phone=? where custid=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			customer.setPhone(customerPhoneUpdateTextField.getText());
			pstmt.setString(1, customer.getPhone());
			customer.setCustId(Integer.parseInt(customerNumUpdateTextField.getText()));
			pstmt.setInt(2, customer.getCustId());
			
			int row = pstmt.executeUpdate();
			
			if (row==1)
				stateLabel.setText("���� ����");
			else
				stateLabel.setText("���� ����");
			
			pstmt.close();
			con.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void deleteCustomer(Customer customer) {
		Connection con = makeConnection();
		
		String sql="delete from customer where name=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			customer.setName(customerDeleteTextField.getText());
			pstmt.setString(1, customer.getName());
			
			int row = pstmt.executeUpdate();
			
			if (row==1)
				stateLabel.setText("���� ����");
			else
				stateLabel.setText("���� ����");
			
			pstmt.close();
			con.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void showCustomerList() throws SQLException, IOException, RuntimeException {
		Connection con = makeConnection();
		
		String file_path = "D:\\";
		Workbook xworkbook = new SXSSFWorkbook();
		Sheet xSheet = xworkbook.createSheet("sheet1");
		Row xRow = null;
		Cell xCell = null;
		
		String sql = "select * from bookstoredb.customer";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		//���� ����
		File file = new File(file_path + "Customer.xlsx");
		FileOutputStream fos = new FileOutputStream(file);

		//ù �� �Է�
		xRow = xSheet.createRow(0);
		xCell = xRow.createCell(0);
		xCell.setCellValue("�� ��ȣ");
		xCell = xRow.createCell(1);
		xCell.setCellValue("����");
		xCell = xRow.createCell(2);
		xCell.setCellValue("�ּ�");
		xCell = xRow.createCell(3);
		xCell.setCellValue("�޴���ȭ");
		xCell = xRow.createCell(4);
		
		int row = 1;
		
		while(rs.next()) {
			// quary ������� ������ ��������
			int custId = rs.getInt(1);
			String custName = rs.getString(2);
			String address = rs.getString(3);
			String phone = rs.getString(4);

			// ������ �Է�
			xRow = xSheet.createRow(row);
			xCell = xRow.createCell(0);
			xCell.setCellValue(custId);
			xCell = xRow.createCell(1);
			xCell.setCellValue(custName);
			xCell = xRow.createCell(2);
			xCell.setCellValue(address);
			xCell = xRow.createCell(3);
			xCell.setCellValue(phone);
			
			row++;
		}
		rs.close();
		stmt.close();
		con.close();
		
		xworkbook.write(fos);
		if(fos != null) {
			fos.close();
		}
	}
	
	public void insertOrder (Order order) {
		Connection con = makeConnection();
		
		String sql="insert into `order` values(?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			order.setOrderId(Integer.parseInt(orderNumTextField.getText()));
			pstmt.setInt(1, order.getOrderId());
			order.setCustId(Integer.parseInt(orderCustomerNumTextField.getText()));
			pstmt.setInt(2, order.getCustId());
			order.setBookId(Integer.parseInt(orderBookNumTextField.getText()));
			pstmt.setInt(3, order.getBookId());
			order.setSalePrice(Integer.parseInt(orderBookPriceTextField.getText()));
			pstmt.setInt(4, order.getSalePrice());
			order.setOrderDate(orderDateTextField.getText());
			pstmt.setString(5, order.getOrderDate());
			
			int row = pstmt.executeUpdate();
			
			if (row==1)
				stateLabel.setText("�߰� ����");
			else
				stateLabel.setText("�߰� ����");
			
			pstmt.close();
			con.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void deleteOrder (Order order) {
		Connection con = makeConnection();
		
		String sql="delete from `order` where orderid=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			order.setOrderId(Integer.parseInt(orderDeleteTextField.getText()));
			pstmt.setInt(1, order.getOrderId());
			
			int row = pstmt.executeUpdate();
			
			if (row==1)
				stateLabel.setText("���� �Ϸ�");
			else
				stateLabel.setText("���� ����");
			
			pstmt.close();
			con.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void showOrderList() throws SQLException, IOException, RuntimeException {
		Connection con = makeConnection();
		
		String file_path = "D:\\";
		Workbook xworkbook = new SXSSFWorkbook();
		Sheet xSheet = xworkbook.createSheet("sheet1");
		Row xRow = null;
		Cell xCell = null;
		
		String sql = "select * from bookstoredb.order";
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		//���� ����
		File file = new File(file_path + "Order.xlsx");
		FileOutputStream fos = new FileOutputStream(file);

		//ù �� �Է�
		xRow = xSheet.createRow(0);
		xCell = xRow.createCell(0);
		xCell.setCellValue("�ֹ� ��ȣ");
		xCell = xRow.createCell(1);
		xCell.setCellValue("�� ��ȣ");
		xCell = xRow.createCell(2);
		xCell.setCellValue("���� ��ȣ");
		xCell = xRow.createCell(3);
		xCell.setCellValue("�Ǹ� ����");
		xCell = xRow.createCell(4);
		xCell.setCellValue("�ֹ� ��¥");
		xCell = xRow.createCell(5);
		
		int row = 1;
		
		while(rs.next()) {
			// quary ������� ������ ��������
			int orderId = rs.getInt(1);
			int custId = rs.getInt(2);
			int bookId = rs.getInt(3);
			int salePrice = rs.getInt(4);
			String orderDate = rs.getString(5);

			// ������ �Է�
			xRow = xSheet.createRow(row);
			xCell = xRow.createCell(0);
			xCell.setCellValue(orderId);
			xCell = xRow.createCell(1);
			xCell.setCellValue(custId);
			xCell = xRow.createCell(2);
			xCell.setCellValue(bookId);
			xCell = xRow.createCell(3);
			xCell.setCellValue(salePrice);
			xCell = xRow.createCell(4);
			xCell.setCellValue(orderDate);
			
			row++;
		}
		rs.close();
		stmt.close();
		con.close();
		
		xworkbook.write(fos);
		if(fos != null) {
			fos.close();
		}
	}
	
	public BookStore() throws SQLException {
		setTitle("�������� ���α׷�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		//��������, ������, �ֹ��ϱ�
		panel1.add(bookButton);
		panel1.add(customerButton);
		panel1.add(orderButton);
		
		//�߰�, ����, ���� ��ư
		bookEditPanel.add(bookAddButton);
		bookEditPanel.add(bookUpdateButton);
		bookEditPanel.add(bookDeleteButton);
		bookEditPanel.add(bookShowListButton);
		
		customerEditPanel.add(customerAddButton);
		customerEditPanel.add(customerUpdateButton);
		customerEditPanel.add(customerDeleteButton);
		customerEditPanel.add(customerShowListButton);
		
		orderEditPanel.add(orderAddButton);
		orderEditPanel.add(orderDeleteButton);
		orderEditPanel.add(orderShowListButton);
		
		//���� ��ȣ
		bookInputPanel.add(bookNumLabel);
		bookInputPanel.add(bookNumTextField);

		//������
		bookInputPanel.add(bookNameLabel);
		bookInputPanel.add(bookNameTextField);
		
		//���ǻ�
		bookInputPanel.add(bookPublisherLabel);
		bookInputPanel.add(bookPublisherTextField);

		//���� ����
		bookInputPanel.add(bookPriceLabel);
		bookInputPanel.add(bookPriceTextField);
		
		//�� ��ȣ
		customerInputPanel.add(customerNumLabel);
		customerInputPanel.add(customerNumTextField);

		//����
		customerInputPanel.add(customerNameLabel);
		customerInputPanel.add(customerNameTextField);
		
		//�ּ�
		customerInputPanel.add(customerAddressLabel);
		customerInputPanel.add(customerAddressTextField);
		
		//�޴���ȭ
		customerInputPanel.add(customerPhoneLabel);
		customerInputPanel.add(customerPhoneTextField);
		
		//�ֹ� ��ȣ
		orderInputPanel.add(orderNumLabel);
		orderInputPanel.add(orderNumTextField);
		
		//�ֹ� �� ��ȣ
		orderInputPanel.add(orderCustomerNumLabel);
		orderInputPanel.add(orderCustomerNumTextField);
		
		//�ֹ� å ��ȣ
		orderInputPanel.add(orderBookNumLabel);
		orderInputPanel.add(orderBookNumTextField);
		
		//�ֹ� ���� ����
		orderInputPanel.add(orderBookPriceLabel);
		orderInputPanel.add(orderBookPriceTextField);
		
		//�ֹ� ��¥
		orderInputPanel.add(orderDateLabel);
		orderInputPanel.add(orderDateTextField);
		
		//���� ǥ��
		stateLabel.setText("���� �������� �޴��Դϴ�.");
		statePanel.add(stateLabel);
		
		//�г�1(��������, ������, �ֹ��ϱ� ��ư) ��ġ
		panel1.setBounds(225, 10, 273, 40);
		
		//�г�2(��ȣ, ������, ���ǻ�, ���� ���̺� �� �ؽ�Ʈ�ʵ�) ��ġ
		bookInputPanel.setBounds(50, 60, 630, 35);
		customerInputPanel.setBounds(50, 60, 639, 35);
		orderInputPanel.setBounds(100, 60, 532, 55);
		
		//���� �г� ��ġ
		statePanel.setBounds(15, 130, 700, 100);
		
		//�г�3(�߰�, ����, ����) ��ġ
		bookEditPanel.setBounds(380, 260, 331, 40);
		customerEditPanel.setBounds(395, 260, 331, 40);
		orderEditPanel.setBounds(428, 260, 331, 40);
		
		//���� ���� ���� �г� ���� ����
		statePanel.setBorder(border);
		statePanel.add(statePanel2);
		statePanel2.add(stateBookNameLabel);
		statePanel2.add(bookNameUpdateTextField);
		statePanel2.add(stateBookPriceLabel);
		statePanel2.add(bookPriceUpdateTextField);
		statePanel2.add(bookUpdateCheckButton);
		StateBookUpdateSetVisibleFalse();
		bookUpdateCheckButton.addActionListener(new MyListener());
		
		//���� ���� ���� �г� ���� ����
		statePanel2.add(stateBookNameLabel2);
		statePanel2.add(bookDeleteTextField);
		statePanel2.add(bookDeleteCheckButton);
		StateBookDeleteSetVisibleFalse();
		bookDeleteCheckButton.addActionListener(new MyListener());
		
		//�� ���� ���� �г� ���� ����
		statePanel2.add(stateCustomerNameButton);
		statePanel2.add(stateCustomerAddressButton);
		statePanel2.add(stateCustomerPhoneButton);

		statePanel2.add(customerNumUpdateLabel);
		statePanel2.add(customerNumUpdateTextField);
		statePanel2.add(stateCustomerNameLabel);
		statePanel2.add(customerNameUpdateTextField);
		statePanel2.add(customerNameUpdateCheckButton);

		statePanel2.add(stateCustomerAddressLabel);
		statePanel2.add(customerAddressUpdateTextField);
		statePanel2.add(customerAddressUpdateCheckButton);
		
		statePanel2.add(stateCustomerPhoneLabel);
		statePanel2.add(customerPhoneUpdateTextField);
		statePanel2.add(customerPhoneUpdateCheckButton);
		stateCustomerNameButton.addActionListener(new MyListener());
		stateCustomerAddressButton.addActionListener(new MyListener());
		stateCustomerPhoneButton.addActionListener(new MyListener());
		customerNameUpdateCheckButton.addActionListener(new MyListener());
		customerAddressUpdateCheckButton.addActionListener(new MyListener());
		customerPhoneUpdateCheckButton.addActionListener(new MyListener());
		StateCustomerUpdateSetVisibleFalse();
		StateCustomerNameUpdateSetVisibleFalse();
		StateCustomerAddressUpdateSetVisibleFalse();
		StateCustomerPhoneUpdateSetVisibleFalse();
		
		//�� ���� ���� �г� ���� ����
		statePanel2.add(stateCustomerNameLabel2);
		statePanel2.add(customerDeleteTextField);
		statePanel2.add(customerDeleteCheckButton);
		StateCustomerDeleteSetVisibleFalse();
		customerDeleteCheckButton.addActionListener(new MyListener());
		
		//�ֹ� ���� ���� �г� ���� ����
		statePanel2.add(stateOrderNumLabel);
		statePanel2.add(orderDeleteTextField);
		statePanel2.add(orderDeleteCheckButton);
		StateOrderDeleteSetVisibleFalse();
		orderDeleteCheckButton.addActionListener(new MyListener());
		
		//�׼� ������
		bookButton.addActionListener(new MyListener());
		customerButton.addActionListener(new MyListener());
		orderButton.addActionListener(new MyListener());
		
		bookAddButton.addActionListener(new MyListener());
		bookUpdateButton.addActionListener(new MyListener());
		bookDeleteButton.addActionListener(new MyListener());
		bookShowListButton.addActionListener(new MyListener());
		
		customerAddButton.addActionListener(new MyListener());
		customerUpdateButton.addActionListener(new MyListener());
		customerDeleteButton.addActionListener(new MyListener());
		customerShowListButton.addActionListener(new MyListener());
		
		orderAddButton.addActionListener(new MyListener());
		orderDeleteButton.addActionListener(new MyListener());
		orderShowListButton.addActionListener(new MyListener());
		
		add(panel1);
		add(bookInputPanel);
		add(customerInputPanel);
		add(orderInputPanel);
		add(bookEditPanel);
		add(customerEditPanel);
		add(orderEditPanel);
		add(statePanel);
		
		customerInputPanel.setVisible(false);
		customerEditPanel.setVisible(false);
		orderInputPanel.setVisible(false);
		orderEditPanel.setVisible(false);
		setSize(750, 360);
		setVisible(true);
	}
	
	class MyListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			//��� �޴� �׼� (��������, ������, �ֹ��ϱ�)
			if (e.getSource() == bookButton) {
				orderInputPanel.setVisible(false);
				orderEditPanel.setVisible(false);

				customerInputPanel.setVisible(false);
				customerEditPanel.setVisible(false);
				
				bookInputPanel.setVisible(true);
				bookEditPanel.setVisible(true);
				
				stateLabel.setText("���� �������� �޴��Դϴ�.");
			} else if (e.getSource() == customerButton) {
				bookInputPanel.setVisible(false);
				bookEditPanel.setVisible(false);
				
				orderInputPanel.setVisible(false);
				orderEditPanel.setVisible(false);
				
				customerInputPanel.setVisible(true);
				customerEditPanel.setVisible(true);
				
				stateLabel.setText("���� ������ �޴��Դϴ�.");
			} else if (e.getSource() == orderButton) {
				bookInputPanel.setVisible(false);
				bookEditPanel.setVisible(false);

				customerInputPanel.setVisible(false);
				customerEditPanel.setVisible(false);
				
				orderInputPanel.setVisible(true);
				orderEditPanel.setVisible(true);
				
				stateLabel.setText("���� �ֹ��ϱ� �޴��Դϴ�.");
			}
			
			//���� ���� �׼�
			if (e.getSource() == bookAddButton) {
				insertBook(book);
				StateBookUpdateSetVisibleFalse();
				StateBookDeleteSetVisibleFalse();
				StateCustomerUpdateSetVisibleFalse();
				StateCustomerNameUpdateSetVisibleFalse();
				StateCustomerAddressUpdateSetVisibleFalse();
				StateCustomerPhoneUpdateSetVisibleFalse();
				StateCustomerDeleteSetVisibleFalse();
				StateOrderDeleteSetVisibleFalse();
			}

			if (e.getSource() == bookUpdateButton) {
				stateLabel.setText("������ ������ ������ �̸��� �ݿ��ϰ��� �ϴ� ������ �����ʽÿ�.");
				StateBookUpdateSetVisibleTrue();
			} else if (e.getSource() == bookUpdateCheckButton) {
				updateBookPrice(book);
				StateBookUpdateSetVisibleFalse();
			} else {
				StateBookUpdateSetVisibleFalse();
			}
			
			if (e.getSource() == bookDeleteButton) {
				stateLabel.setText("������ ������ �̸��� �Է��ϼ���.");
				StateBookDeleteSetVisibleTrue();
			} else if (e.getSource() == bookDeleteCheckButton) {
				deleteBook(book);
				StateBookDeleteSetVisibleFalse();
			} else {
				StateBookDeleteSetVisibleFalse();
			}
			
			if (e.getSource() == bookShowListButton) {
				try {
					showBookList();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (RuntimeException e1) {
					e1.printStackTrace();
				}
				stateLabel.setText("D ����̺� ��ο� Book.xlsx ������ Ȯ���ϼ���.");
			}
			
			//�� ���� �׼�
			if (e.getSource() == customerAddButton) {
				insertCustomer(customer);
				StateBookUpdateSetVisibleFalse();
				StateBookDeleteSetVisibleFalse();
				StateCustomerUpdateSetVisibleFalse();
				StateCustomerNameUpdateSetVisibleFalse();
				StateCustomerAddressUpdateSetVisibleFalse();
				StateCustomerPhoneUpdateSetVisibleFalse();
				StateCustomerDeleteSetVisibleFalse();
				StateOrderDeleteSetVisibleFalse();
			}
			
			if (e.getSource() == customerUpdateButton) {
				stateLabel.setText("������ �� ������ �����ϼ���.");
				StateCustomerUpdateSetVisibleTrue();
				StateCustomerNameUpdateSetVisibleFalse();
				StateCustomerAddressUpdateSetVisibleFalse();
				StateCustomerPhoneUpdateSetVisibleFalse();
			} else if (e.getSource() == stateCustomerNameButton) {
				stateLabel.setText("������ ���� ��ȣ�� �ݿ��ϰ��� �ϴ� �̸��� �Է��ϼ���.");
				StateCustomerNameUpdateSetVisibleTrue();
				StateCustomerUpdateSetVisibleFalse();
			} else if (e.getSource() == customerNameUpdateCheckButton) {
				updateCustomerName(customer);
				StateCustomerNameUpdateSetVisibleFalse();
			} else if (e.getSource() == stateCustomerAddressButton) {
				stateLabel.setText("������ ���� ��ȣ�� �ݿ��ϰ��� �ϴ� �ּҸ� �Է��ϼ���.");
				StateCustomerAddressUpdateSetVisibleTrue();
				StateCustomerUpdateSetVisibleFalse();
			} else if (e.getSource() == customerAddressUpdateCheckButton) {
				updateCustomerAddress(customer);
				StateCustomerAddressUpdateSetVisibleFalse();
			} else if (e.getSource() == stateCustomerPhoneButton) {
				stateLabel.setText("������ ���� ��ȣ�� �ݿ��ϰ��� �ϴ� �޴���ȭ�� �Է��ϼ���.");
				StateCustomerPhoneUpdateSetVisibleTrue();
				StateCustomerUpdateSetVisibleFalse();
			} else if (e.getSource() == customerPhoneUpdateCheckButton) {
				updateCustomerPhone(customer);
				StateCustomerPhoneUpdateSetVisibleFalse();
			} else {
				StateCustomerUpdateSetVisibleFalse();
				StateCustomerNameUpdateSetVisibleFalse();
				StateCustomerAddressUpdateSetVisibleFalse();
				StateCustomerPhoneUpdateSetVisibleFalse();
			}
			
			if (e.getSource() == customerDeleteButton) {
				stateLabel.setText("������ ���� �̸��� �Է��ϼ���.");
				StateCustomerDeleteSetVisibleTrue();
			} else if (e.getSource() == customerDeleteCheckButton) {
				deleteCustomer(customer);
				StateCustomerDeleteSetVisibleFalse();
			} else {
				StateCustomerDeleteSetVisibleFalse();
			}
			
			if (e.getSource() == customerShowListButton) {
				try {
					showCustomerList();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (RuntimeException e1) {
					e1.printStackTrace();
				}
				stateLabel.setText("D ����̺� ��ο� Customer.xlsx ������ Ȯ���ϼ���.");
			}
			
			//�ֹ� �ϱ� �׼�
			if (e.getSource() == orderAddButton) {
				insertOrder(order);
				StateBookUpdateSetVisibleFalse();
				StateBookDeleteSetVisibleFalse();
				StateCustomerUpdateSetVisibleFalse();
				StateCustomerNameUpdateSetVisibleFalse();
				StateCustomerAddressUpdateSetVisibleFalse();
				StateCustomerPhoneUpdateSetVisibleFalse();
				StateCustomerDeleteSetVisibleFalse();
				StateOrderDeleteSetVisibleFalse();
			}
			
			if (e.getSource() == orderDeleteButton) {
				stateLabel.setText("������ �ֹ��� ��ȣ�� �Է��ϼ���.");
				StateOrderDeleteSetVisibleTrue();
			} else if (e.getSource() == orderDeleteCheckButton) {
				deleteOrder(order);
				StateOrderDeleteSetVisibleFalse();
			} else {
				StateOrderDeleteSetVisibleFalse();
			}
			
			if (e.getSource() == orderShowListButton) {
				try {
					showOrderList();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (RuntimeException e1) {
					e1.printStackTrace();
				}
				stateLabel.setText("D ����̺� ��ο� Order.xlsx ������ Ȯ���ϼ���.");
			}
		}
	}
	
	public static void main(String[] args) throws SQLException {
		BookStore bs = new BookStore();
	}

}
