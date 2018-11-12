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

public class DeleteBookAction implements Action{
	private static final String formPath = "/jsp/deleteBook.jsp";
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("POST")) {
			doPost(request, response);
		}
	}

	private void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = JDBCConnection.getConnection();
		
		BookDAO bookDao = BookDAO.getInstance();
		HttpSession session = request.getSession();
		Book book = (Book)session.getAttribute("selectedBook");
		int book_id = book.getBook_id();
		System.out.println(book_id);
		
		int result = bookDao.deleteBook(conn, book);
		
		request.setAttribute("result", result);
		
		JDBCCloser.close(conn);
		
		request.getRequestDispatcher(formPath).forward(request, response);
	}	
}
