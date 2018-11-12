package mvc.action;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.dao.BookDAO;
import mvc.dao.RentalDAO;
import mvc.model.Book;
import mvc.model.Rental;
import mvc.util.JDBCCloser;
import mvc.util.JDBCConnection;

public class RentalInfoAction implements Action{
	private static final String formPath = "/jsp/rentalInfo.jsp";
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("GET")) {
			doGet(request, response);
		}
	}

	private void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = JDBCConnection.getConnection();
		
		RentalDAO rentalDao = RentalDAO.getInstance();
		int rental_id = Integer.parseInt(request.getParameter("rental_id"));
		Rental rental = rentalDao.selectRentalInfo(conn, rental_id);
		
		request.setAttribute("rental", rental);
		HttpSession session = request.getSession();
		session.setAttribute("selectedRental", rental);
		
		JDBCCloser.close(conn);
		
		request.getRequestDispatcher(formPath).forward(request, response);
		
	}

	
}
