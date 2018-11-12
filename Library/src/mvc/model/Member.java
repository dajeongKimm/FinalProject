package mvc.model;

import java.util.Date;

public class Member {
	private String member_id;
	private String member_password;
	private int member_type;
	private String member_name;
	private int member_age;
	private String member_tel;
	private String member_address;
	private String member_email;
	private String member_gender;
	private String member_photo;
	private Date member_registDate;

	public Member() {
	}

	public Member(String member_id, String member_password, int member_type, String member_name, int member_age,
			String member_tel, String member_address, String member_email, String member_gender, String member_photo,
			Date member_registDate) {
		this.member_id = member_id;
		this.member_password = member_password;
		this.member_type = member_type;
		this.member_name = member_name;
		this.member_age = member_age;
		this.member_tel = member_tel;
		this.member_address = member_address;
		this.member_email = member_email;
		this.member_gender = member_gender;
		this.member_photo = member_photo;
		this.member_registDate = member_registDate;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_password() {
		return member_password;
	}

	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}

	public int getMember_type() {
		return member_type;
	}

	public void setMember_type(int member_type) {
		this.member_type = member_type;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public int getMember_age() {
		return member_age;
	}

	public void setMember_age(int member_age) {
		this.member_age = member_age;
	}

	public String getMember_tel() {
		return member_tel;
	}

	public void setMember_tel(String member_tel) {
		this.member_tel = member_tel;
	}

	public String getMember_address() {
		return member_address;
	}

	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_gender() {
		return member_gender;
	}

	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}

	public String getMember_photo() {
		return member_photo;
	}

	public void setMember_photo(String member_photo) {
		this.member_photo = member_photo;
	}

	public Date getMember_registDate() {
		return member_registDate;
	}

	public void setMember_registDate(Date member_registDate) {
		this.member_registDate = member_registDate;
	}

}
