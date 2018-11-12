package mvc.dao;

import java.sql.*;
//������ ����� ��ȯ�ϱ� ���� util ��Ű�� ����Ʈ
//(�÷��� ��ü�� Ȱ��)
import java.util.*;
//select ������ ������ �� ������ �����ϱ� ����
//�� Ŭ���� ����Ʈ
import mvc.model.*;
import mvc.util.JDBCCloser;

public class BookDAO {
	private static BookDAO instance = new BookDAO();
	public static BookDAO getInstance() {
		return instance;
	}
	private BookDAO() {}
	
	private Book generateDataObject(ResultSet rs) throws SQLException {
		Book book = new Book();
		
		book.setBook_id(rs.getInt("book_id"));
		book.setBook_title(rs.getString("book_title"));
		book.setBook_author(rs.getString("book_author"));
		book.setBook_publisher(rs.getString("book_publisher"));
		book.setBook_price(rs.getDouble("book_price"));
		book.setBook_image(rs.getString("book_image"));
		book.setBook_registdate(rs.getTimestamp("book_registdate"));
		
		return book;
	}
	
	public ArrayList<Book> selectAllBook(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Book> books = new ArrayList<>();
		
		try {
			String query = 
					"select * from book";
			pstmt = conn.prepareStatement(query);			
			
			rs = pstmt.executeQuery();
			
			while(rs.next())				
				books.add(generateDataObject(rs));			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCCloser.close(rs);
			JDBCCloser.close(pstmt);
		}
		
		return books;
	}
	
	public Book selectBook(Connection conn, int book_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book book = null;
		
		try {
			String query = 
					"select * from book where book_id = ?";
			pstmt = conn.prepareStatement(query);	
			pstmt.setInt(1, book_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())				
				book = generateDataObject(rs);			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCCloser.close(rs);
			JDBCCloser.close(pstmt);
		}
		
		return book;
	}
	
	public ArrayList<Book> selectBookUsingCondition(
			Connection conn, String target, String value) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Book> books = new ArrayList<>();
		
		try {
			String query = 
					"select * from book where " + target + 
					" like ?";
			pstmt = conn.prepareStatement(query);	
			pstmt.setString(1, "%" + value + "%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next())				
				books.add(generateDataObject(rs));			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCCloser.close(rs);
			JDBCCloser.close(pstmt);
		}
		
		return books;
	}
	
	public ArrayList<Book> selectBookUsingCondition(
				Connection conn, String value) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Book> books = new ArrayList<>();
		
		try {
			String query = 
					"select * from book where book_title like ? "
					+ " or book_author like ? or "
					+ " book_publisher like ?";
			pstmt = conn.prepareStatement(query);	
			pstmt.setString(1, "%" + value + "%");
			pstmt.setString(2, "%" + value + "%");
			pstmt.setString(3, "%" + value + "%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next())				
				books.add(generateDataObject(rs));			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCCloser.close(rs);
			JDBCCloser.close(pstmt);
		}
		
		return books;
	}
	
	public int insertBook(Connection conn, Book book) {
		PreparedStatement pstmt = null;		
		int count = 0;
		
		try {
			String query = 
					"insert into book (book_title, book_author, book_publisher, book_price, book_image, book_registdate) " 
					+ "values (?,?,?,?,?,now())";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, book.getBook_title());
			pstmt.setString(2, book.getBook_author());
			pstmt.setString(3, book.getBook_publisher());
			pstmt.setDouble(4, book.getBook_price());
			pstmt.setString(5, book.getBook_image());			
			
			System.out.println(pstmt.toString());
			
			count = pstmt.executeUpdate();			
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			JDBCCloser.close(pstmt);
		}
		
		return count;
	}
	
	public int updateBook(Connection conn, Book book) {
		PreparedStatement pstmt = null;
		int count = 0;
		
		try {
			String query = "update book set book_title = ?, book_author = ?, book_publisher = ?, book_price = ? "
					+"where book_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, book.getBook_title());
			pstmt.setString(2, book.getBook_author());
			pstmt.setString(3, book.getBook_publisher());
			pstmt.setDouble(4, book.getBook_price());
			pstmt.setInt(5, book.getBook_id());
			
			System.out.println(pstmt.toString());
			
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCCloser.close(pstmt);
		}
		return count;
	}
	
	public int deleteBook(Connection conn, Book book) {
		PreparedStatement pstmt = null;
		int count = 0;
		
		try {
			String query = "delete from book where book_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, book.getBook_id());
			
			System.out.println(pstmt.toString());
			
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCCloser.close(pstmt);
		}
		return count;
	}
}













