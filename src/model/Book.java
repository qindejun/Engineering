package model;

import javax.print.event.PrintJobAttributeEvent;

public class Book {
	public Book(int id, String bookName, String author, String sex, Float price, Integer bookTypeID, String bookDesc) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.sex = sex;
		this.price = price;
		this.bookTypeID = bookTypeID;
		this.bookDesc = bookDesc;
	}
	private int id;
	private String bookName;
	private String author;
	private String sex;
	private Float price;
    private Integer bookTypeID; 
    private String bookTypeName;
    private String bookDesc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getBookTypeID() {
		return bookTypeID;
	}
	public void setBookTypeID(Integer bookTypeID) {
		this.bookTypeID = bookTypeID;
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	public Book(String bookName, String author, String sex, Float price, Integer bookTypeID, String bookDesc) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.sex = sex;
		this.price = price;
		this.bookTypeID = bookTypeID;
		this.bookDesc = bookDesc;
	}
	public Book() {
		super();
	}
	public Book(String bookName, String author, Integer bookTypeID) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.bookTypeID = bookTypeID;
	}

	
	
}
