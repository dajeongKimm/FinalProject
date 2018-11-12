package mvc.dao;

//쿼리를 수행하기 위한 sql 패키지 임포트
import java.sql.*;
//쿼리의 결과를 반환하기 위한 util 패키지 임포트
//(컬렉션 객체를 활용)
import java.util.*;
//select 쿼리를 수행한 후 정보를 저장하기 위한
//모델 클래스 임포트
import mvc.model.*;
import mvc.util.*;

public class ReservationDAO {
	private static ReservationDAO instance = new ReservationDAO();

	public static ReservationDAO getInstance() {
		return instance;
	}

	private ReservationDAO() {
	}

	private Reservation generateDataObject(ResultSet rs) throws SQLException {
		Reservation reservation = new Reservation();

		reservation.setReservation_id(rs.getInt("reservation_id"));
		reservation.setMember_id(rs.getString("member_id"));
		reservation.setMember_name(rs.getString("member_name"));
		reservation.setBook_id(rs.getInt("book_id"));
		reservation.setBook_title(rs.getString("book_title"));
		reservation.setReservation_registdate(rs.getDate("reservation_registdate"));

		return reservation;
	}

	public ArrayList<Reservation> selectReservation(Connection conn, String member_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Reservation> reservations = new ArrayList<>();

		try {
			String query = "select * from reservation_view where member_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member_id);

			rs = pstmt.executeQuery();

			while (rs.next())
				reservations.add(generateDataObject(rs));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCCloser.close(rs);
			JDBCCloser.close(pstmt);
		}

		return reservations;
	}

	public Reservation selectReservation(Connection conn, int book_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Reservation reservation = null;

		try {
			String query = "select * from reservation_view " + "where book_id = ? " + "order by reservation_id";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, book_id);

			rs = pstmt.executeQuery();

			if (rs.next())
				reservation = generateDataObject(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCCloser.close(rs);
			JDBCCloser.close(pstmt);
		}

		return reservation;
	}

	public Reservation selectReservation(
			Connection conn, int book_id, String member_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Reservation reservation = null;

		try {
			String query = 
					"select * from reservation_view " 
					+ "where book_id = ? and member_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, book_id);
			pstmt.setString(2, member_id);

			rs = pstmt.executeQuery();

			if (rs.next())
				reservation = generateDataObject(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCCloser.close(rs);
			JDBCCloser.close(pstmt);
		}

		return reservation;
	}

	public int insertReservation(Connection conn, Reservation reservation) {
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			String query = "insert into reservation (book_id, member_id, reservation_registdate) "
					+ "values (?,?, now())";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reservation.getBook_id());
			pstmt.setString(2, reservation.getMember_id());

			System.out.println(pstmt.toString());

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCCloser.close(pstmt);
		}

		return count;
	}

	public int deleteReservation(Connection conn, int reservation_id) {
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			String query = "delete from reservation " + "where reservation_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reservation_id);

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
