package mvc.dao;

import java.sql.*;
import java.util.ArrayList;

import mvc.model.Article;
import mvc.model.Book;
import mvc.model.Member;
import mvc.util.JDBCCloser;

public class ArticleDAO {
	
	private static ArticleDAO instance = new ArticleDAO();
	public static ArticleDAO getInstance() {
		return instance;
	}
	private ArticleDAO() {}
	
	private Article generateDataObject(ResultSet rs) throws SQLException {
		Article article;
		article = new Article(
					rs.getInt("article_no"), 
					rs.getString("member_id"), 
					rs.getString("member_name"), 
					rs.getString("title"), 
					rs.getString("contents"),
					rs.getDate("regdate"),
					rs.getDate("moddate"),
					rs.getInt("read_count"));
		return article;
	}
	
	public ArrayList<Article> selectAllArticle(Connection conn, int startIndex, int count) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Article> articles = new ArrayList<>();
		
		try {
			String query = 
					"select * from article limit ?, ?";
			pstmt = conn.prepareStatement(query);		
			pstmt.setInt(1, startIndex);
			pstmt.setInt(2, count);
			
			rs = pstmt.executeQuery();
			
			while(rs.next())				
				articles.add(generateDataObject(rs));			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCCloser.close(rs);
			JDBCCloser.close(pstmt);
		}
		
		return articles;
	}
	
	//전채 article수 구하기.
	public int getRecordCount(Connection conn){
		String query = "select count(*) from article";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			count = 0;
		}
		
		JDBCCloser.close(pstmt);
		JDBCCloser.close(rs);
		return count;
	}
	
	//게시글 등록
	public int insertMember(Connection conn, Article article) {
		PreparedStatement pstmt = null;		
		int count = 0;
		
		try {
			String query = 
					"insert into article (member_id, member_name, title, contents, regdate, moddate, read_count) values (?,?,?,?,now(), now(),0)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, article.getMember_id());	
			pstmt.setString(2, article.getMember_name());			
			pstmt.setString(3, article.getTitle());
			pstmt.setString(4, article.getContents());
						
			System.out.println(pstmt.toString());
			
			count = pstmt.executeUpdate();			
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			JDBCCloser.close(pstmt);
		}
		return count;
	}
	
	//게시글 읽어오기
	public Article selectArticle(Connection conn, int article_no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Article article = null;
		
		try {
			String query = "select * from article where article_no = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, article_no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())				 
				article = generateDataObject(rs);			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCCloser.close(rs);
			JDBCCloser.close(pstmt);
		}	
		return article;
	}
	
	//조회수 증가
	public void increaseReadCount(Connection conn, int article_no) {
		PreparedStatement pstmt = null;
		
		try {
			String query = "update article set read_count=read_count+1 where article_no = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, article_no);
			
			pstmt.executeUpdate();
			
			System.out.println(pstmt.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


















