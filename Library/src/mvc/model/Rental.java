package mvc.model;

import java.util.Date;

public class Rental {
	private int rental_id;
	private String member_id;
	private String member_name;
	private int book_id;
	private String book_title;
	private Date rental_registdate;
	private boolean rental_isReturn;
	private Date rental_returndate;

	public Rental() {
	}

	public Rental(int rental_id, String member_id, String member_name, int book_id, String book_title,
			Date rental_registdate, boolean rental_isReturn, Date rental_returndate) {
		super();
		this.rental_id = rental_id;
		this.member_id = member_id;
		this.member_name = member_name;
		this.book_id = book_id;
		this.book_title = book_title;
		this.rental_registdate = rental_registdate;
		this.rental_isReturn = rental_isReturn;
		this.rental_returndate = rental_returndate;
	}

	public int getRental_id() {
		return rental_id;
	}

	public void setRental_id(int rental_id) {
		this.rental_id = rental_id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
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

	public Date getRental_registdate() {
		return rental_registdate;
	}

	public void setRental_registdate(Date rental_registdate) {
		this.rental_registdate = rental_registdate;
	}

	public boolean isRental_isReturn() {
		return rental_isReturn;
	}

	public void setRental_isReturn(boolean rental_isReturn) {
		this.rental_isReturn = rental_isReturn;
	}

	public Date getRental_returndate() {
		return rental_returndate;
	}

	public void setRental_returndate(Date rental_returndate) {
		this.rental_returndate = rental_returndate;
	}

}
