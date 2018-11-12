package mvc.action;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.dao.BookDAO;
import mvc.dao.RentalDAO;
import mvc.dao.ReservationDAO;
import mvc.model.Book;
import mvc.model.Rental;
import mvc.model.Reservation;
import mvc.util.JDBCCloser;
import mvc.util.JDBCConnection;

public class BookInfoAction implements Action{
	private static final String formPath = "/jsp/bookInfo.jsp";
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("GET")) {
			doGet(request, response);
		}
	}

	private void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = JDBCConnection.getConnection();
		
		BookDAO bookDao = BookDAO.getInstance();
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		Book book = bookDao.selectBook(conn, book_id);
		
		//선택된 book정보 저장하기
		HttpSession session = request.getSession();
		session.setAttribute("selectedBook", book);
		//선택된 book의 반납여부 상태 확인하기 isReturn 값이 1이면 반납된 상태(대여가능)
		//										0이면 반납 안된 상태(대여불가능)
		RentalDAO rentalDao = RentalDAO.getInstance();
		Rental rental = rentalDao.selectRental(conn, book_id);
		ReservationDAO reservationDao = ReservationDAO.getInstance();
		Reservation reservation = reservationDao.selectReservation(conn, book_id);
		
		session.setAttribute("selectedRental", rental);
		session.setAttribute("selectedReservation", reservation);
		
		request.setAttribute("book", book);
		
		
		JDBCCloser.close(conn);
		
		request.getRequestDispatcher(formPath).forward(request, response);
		
	}

	
}
