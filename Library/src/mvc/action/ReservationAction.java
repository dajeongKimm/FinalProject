package mvc.action;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.dao.RentalDAO;
import mvc.dao.ReservationDAO;
import mvc.model.Book;
import mvc.model.Member;
import mvc.model.Rental;
import mvc.model.Reservation;
import mvc.util.JDBCConnection;

public class ReservationAction implements Action{
	
	private static final String resultPath = "/jsp/reservationResult.jsp";

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("POST")) {
			doPost(request, response);
		}
		
	}

	private void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = JDBCConnection.getConnection();
		//로그인된 아이디 가져오기
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginMember");
		String member_id = member.getMember_id();
		String member_name = member.getMember_name();
		//선택된 책정보 가져오기
		Book book = (Book)session.getAttribute("selectedBook");
		int book_id = book.getBook_id();
		String book_title = book.getBook_title();
		
		ReservationDAO reservationDao = ReservationDAO.getInstance();
		
		//insert할 reservation 객체 생성
		Reservation reservation = new Reservation();
		reservation.setBook_id(book_id);
		reservation.setMember_id(member_id);
		
		//insert 하기
		int result = reservationDao.insertReservation(conn, reservation);
		
		request.setAttribute("result", result);
		
		request.getRequestDispatcher(resultPath).forward(request, response);
		
	}
}
