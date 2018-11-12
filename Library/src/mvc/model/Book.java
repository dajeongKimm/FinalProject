package mvc.model;

import java.util.Date;

public class Book {
	private int book_id;
	private String book_title;
	private String book_author;
	private String book_publisher;
	private double book_price;
	private String book_image;
	private Date book_registdate;

	public Book() {
	}

	public Book(int book_id, String book_title, String book_author, String book_publisher, double book_price,
			String book_image, Date book_registdate) {
		this.book_id = book_id;
		this.book_title = book_title;
		this.book_author = book_author;
		this.book_publisher = book_publisher;
		this.book_price = book_price;
		this.book_image = book_image;
		this.book_registdate = book_registdate;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public String getBook_publisher() {
		return book_publisher;
	}

	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}

	public double getBook_price() {
		return book_price;
	}

	public void setBook_price(double book_price) {
		this.book_price = book_price;
	}

	public String getBook_image() {
		return book_image;
	}

	public void setBook_image(String book_image) {
		this.book_image = book_image;
	}

	public Date getBook_registdate() {
		return book_registdate;
	}

	public void setBook_registdate(Date book_registdate) {
		this.book_registdate = book_registdate;
	}

}
