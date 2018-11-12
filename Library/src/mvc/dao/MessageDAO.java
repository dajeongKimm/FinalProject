package mvc.dao;

//쿼리를 수행하기 위한 sql 패키지 임포트
import java.sql.*;
//쿼리의 결과를 반환하기 위한 util 패키지 임포트
//(컬렉션 객체를 활용)
import java.util.*;
import java.util.Date;

//select 쿼리를 수행한 후 정보를 저장하기 위한
//모델 클래스 임포트
import mvc.model.*;
import mvc.util.*;

public class MessageDAO {
	private static MessageDAO instance = new MessageDAO();

	public static MessageDAO getInstance() {
		return instance;
	}

	private MessageDAO() {
	}
	
	private Message generateDataObject(ResultSet rs) throws SQLException {
		Message message = new Message();
		
		message.setMessage_id(rs.getInt("message_id"));
		message.setSender_id(rs.getString("sender_id"));
		message.setSender_name(rs.getString("sender_name"));
		message.setReceiver_id(rs.getString("receiver_id"));
		message.setReceiver_name(rs.getString("receiver_name"));		
		message.setMessage_registdate(rs.getDate("message_registdate"));
		message.setMessage_readdate(rs.getDate("message_readdate"));
		message.setMessage_content(rs.getString("message_content"));

		return message;
	}
	
	public Message selectMessage(Connection conn, int message_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Message message = null;
		
		try {
			String query = 
					"select * from message_view where message_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, message_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())				 
				message = generateDataObject(rs);			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCCloser.close(rs);
			JDBCCloser.close(pstmt);
		}
		
		return message;
	}
	
	public int selectMessage(Connection conn, Member loginMember) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			String query = 
					"select count(*) from message_view where receiver_id = ? and message_readdate is null";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, loginMember.getMember_id());
			
			
			rs = pstmt.executeQuery();
			rs.next();
			count = rs.getInt(1);			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCCloser.close(rs);
			JDBCCloser.close(pstmt);
		}
		
		return count;
	}
	
	//전체 읽기
	public ArrayList<Message> selectMessage(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Message> messages = new ArrayList<>();
		
		try {
			String query =  "select * from message_view";
			pstmt = conn.prepareStatement(query);			
			
			rs = pstmt.executeQuery();
			
			while(rs.next())				 
				messages.add(generateDataObject(rs));	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCCloser.close(rs);
			JDBCCloser.close(pstmt);
		}
		
		return messages;
	}
	
	
	public ArrayList<Message> selectMessageUsingCondition(
			Connection conn, String target, String value, String target_id, Member loginMember) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Message> messages = new ArrayList<>();
		
		try {
			String query = 
					"select * from message_view "
					+ "where " + target + " like ? and "+ target_id + " = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + value + "%");
			pstmt.setString(2, loginMember.getMember_id());
			
			rs = pstmt.executeQuery();
			
			while(rs.next())				 
				messages.add(generateDataObject(rs));			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCCloser.close(rs);
			JDBCCloser.close(pstmt);
		}
		
		return messages;
	}
	
	public int insertMessage(Connection conn, Message message) {
		PreparedStatement pstmt = null;		
		int count = 0;
		
		try {
			String query = 
					"insert into message (send_member_id, receive_member_id, message_content,message_registdate) " 
					+ "values (?,?,?,now())";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, message.getSender_id());
			pstmt.setString(2, message.getReceiver_id());			
			pstmt.setString(3, message.getMessage_content());					
			
			System.out.println(pstmt.toString());
			
			count = pstmt.executeUpdate();			
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			JDBCCloser.close(pstmt);
		}
		
		return count;
	}
	
	public int updateMessage(Connection conn, int message_id) {
		PreparedStatement pstmt = null;		
		int count = 0;	
		
		try {
			String query = 
					"update message set message_readdate = now()"
					+ " where message_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, message_id);
			
			System.out.println(pstmt.toString());
			
			// 0 이면 실패, 1 이면 성공
			count = pstmt.executeUpdate();		
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			JDBCCloser.close(pstmt);
		}
		
		return count;
	}
}













