package mvc.dao;

// 쿼리를 수행하기 위한 sql 패키지 임포트
import java.sql.*;
// 쿼리의 결과를 반환하기 위한 util 패키지 임포트
// (컬렉션 객체를 활용)
import java.util.*;
import mvc.model.*;
import mvc.util.*;

// DAO : Database Access Object
// 데이터베이스에 접속하여 쿼리를 수행하고
// 결과를 반환하는 클래스를 지칭하는 용어
public class MemberDAO {
	// DAO 클래스들은 객체를 여러개 생성하여 사용하는 경우
	// 데이터베이스에 연결이 많아질 수 있어
	// 전체적인 성능 저하를 일으킬 수 있습니다.
	// 대부분 DAO 클래스들은 싱글턴 패턴을 구현합니다.
	
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	private MemberDAO() {}
	
	private Member generateDataObject(ResultSet rs) throws SQLException {
		Member member;
		member = new Member(
					rs.getString("member_id"), 
					rs.getString("member_password"), 
					rs.getInt("member_type"), 
					rs.getString("member_name"), 
					rs.getInt("member_age"), 
					rs.getString("member_tel"), 
					rs.getString("member_address"), 
					rs.getString("member_email"), 
					rs.getString("member_gender"), 
					rs.getString("member_photo"), 
					rs.getDate("member_registDate"));
		return member;
	}
	
	public Member selectMember(Connection conn, String member_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		
		try {
			String query = 
					"select * from member where member_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())				 
				member = generateDataObject(rs);			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCCloser.close(rs);
			JDBCCloser.close(pstmt);
		}
		
		return member;
	}
	
	//여러개의 객체를 넘겨줌.
	public ArrayList<Member> selectMemberUsingCondition(
			Connection conn, String target, String value, Member loginMember) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Member> members = new ArrayList<>();
		
		try {
			String query = 
					"select * from member "
					+ "where " + target + " like ? and member_id != ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + value + "%");
			pstmt.setString(2, loginMember.getMember_id());
			
			rs = pstmt.executeQuery();
			
			while(rs.next())				 
				members.add(generateDataObject(rs));			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCCloser.close(rs);
			JDBCCloser.close(pstmt);
		}
		
		return members;
	}
	
	public int insertMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;		
		int count = 0;
		
		try {
			String query = 
					"insert into member values (?,?, default,?,?,?,?,?,?,?, now())";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMember_id());
			pstmt.setString(2, member.getMember_password());			
			pstmt.setString(3, member.getMember_name());
			pstmt.setInt(4, member.getMember_age());
			pstmt.setString(5, member.getMember_tel());
			pstmt.setString(6, member.getMember_address());
			pstmt.setString(7, member.getMember_email());
			pstmt.setString(8, member.getMember_gender());
			pstmt.setString(9, member.getMember_photo());			
			
			System.out.println(pstmt.toString());
			
			count = pstmt.executeUpdate();			
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			JDBCCloser.close(pstmt);
		}
		
		return count;
	}
	
	// 패스워드를 수정하는 메소드
	public int updateMember(Connection conn, Member member, String newPassword) {
		PreparedStatement pstmt = null;		
		int count = 0;	
		
		try {
			String query = 
					"update member set member_password = ?"
					+ " where member_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newPassword);
			pstmt.setString(2, member.getMember_id());
			
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
	
	public int updateMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;		
		int count = 0;	
		
		try {
			String query = 
					"update member set   member_type = ?, member_name = ?, member_age = ?, " 
					+ " member_tel = ?, member_address = ?, member_email = ?, "
					+ " member_gender = ?, member_photo = ? "
					+ " where member_id = ?";
			pstmt = conn.prepareStatement(query);
			//pstmt.setString(1, member.getMember_id());
			//pstmt.setString(2, member.getMember_password());
			pstmt.setInt(1, member.getMember_type());
			pstmt.setString(2, member.getMember_name());
			pstmt.setInt(3, member.getMember_age());
			pstmt.setString(4, member.getMember_tel());
			pstmt.setString(5, member.getMember_address());
			pstmt.setString(6, member.getMember_email());
			pstmt.setString(7, member.getMember_gender());
			pstmt.setString(8, member.getMember_photo());
			pstmt.setString(9, member.getMember_id());
			
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
	
	/*
	public int deleteMember(Connection conn, Member member) {
		
	}
	*/
}


















