package mvc.model;

import java.sql.Date;

public class Article {
	
	private int article_no;
	private String member_id;
	private String member_name;
	private String title;
	private String contents;
	private Date regdate;
	private Date moddate;
	private int read_count;
	
	public Article() {}

	public Article(int article_no, String member_id, String member_name, String title, String contents, Date regdate,
			Date moddate, int read_count) {
		super();
		this.article_no = article_no;
		this.member_id = member_id;
		this.member_name = member_name;
		this.title = title;
		this.contents = contents;
		this.regdate = regdate;
		this.moddate = moddate;
		this.read_count = read_count;
	}

	public int getArticle_no() {
		return article_no;
	}

	public void setArticle_no(int article_no) {
		this.article_no = article_no;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getModdate() {
		return moddate;
	}

	public void setModdate(Date moddate) {
		this.moddate = moddate;
	}

	public int getRead_count() {
		return read_count;
	}

	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}
}
