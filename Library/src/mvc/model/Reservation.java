package mvc.model;

import java.util.*;

public class Reservation {
	private int reservation_id;
	private String member_id;
	private String member_name;
	private int book_id;
	private String book_title;
	private Date reservation_registdate;

	public Reservation() {
	}

	public Reservation(int reservation_id, String member_id, String member_name, int book_id, String book_title,
			Date reservation_registdate) {
		this.reservation_id = reservation_id;
		this.member_id = member_id;
		this.member_name = member_name;
		this.book_id = book_id;
		this.book_title = book_title;
		this.reservation_registdate = reservation_registdate;
	}

	public int getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
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

	public Date getReservation_registdate() {
		return reservation_registdate;
	}

	public void setReservation_registdate(Date reservation_registdate) {
		this.reservation_registdate = reservation_registdate;
	}

}
