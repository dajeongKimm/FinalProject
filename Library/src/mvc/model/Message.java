package mvc.model;

import java.util.Date;

public class Message {
	private int message_id;
	private String sender_id;
	private String sender_name;
	private String receiver_id;
	private String receiver_name;
	private Date message_registdate;
	private Date message_readdate;
	private String message_content;

	public Message() {
	}

	public Message(int message_id, String sender_id, String sender_name, String receiver_id, String receiver_name,
			Date message_registdate, Date message_readdate, String message_content) {
		this.message_id = message_id;
		this.sender_id = sender_id;
		this.sender_name = sender_name;
		this.receiver_id = receiver_id;
		this.receiver_name = receiver_name;
		this.message_registdate = message_registdate;
		this.message_readdate = message_readdate;
		this.message_content = message_content;
	}

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

	public String getSender_id() {
		return sender_id;
	}

	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}

	public String getSender_name() {
		return sender_name;
	}

	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}

	public String getReceiver_id() {
		return receiver_id;
	}

	public void setReceiver_id(String receiver_id) {
		this.receiver_id = receiver_id;
	}

	public String getReceiver_name() {
		return receiver_name;
	}

	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}

	public Date getMessage_registdate() {
		return message_registdate;
	}

	public void setMessage_registdate(Date message_registdate) {
		this.message_registdate = message_registdate;
	}

	public Date getMessage_readdate() {
		return message_readdate;
	}

	public void setMessage_readdate(Date message_readdate) {
		this.message_readdate = message_readdate;
	}

	public String getMessage_content() {
		return message_content;
	}

	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}

}
