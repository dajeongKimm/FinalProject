package mvc.action;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.dao.RentalDAO;
import mvc.model.Book;
import mvc.model.Member;
import mvc.model.Rental;
import mvc.util.JDBCCloser;
import mvc.util.JDBCConnection;

public class ReturnAction implements Action{
	
	private static final String resultPath = "/jsp/returnResult.jsp";

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("POST")) {
			doPost(request, response);
		}
		
	}

	private void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = JDBCConnection.getConnection();
		
		RentalDAO rentalDao = RentalDAO.getInstance();
		HttpSession session = request.getSession();
		Rental rental = (Rental)session.getAttribute("selectedRental");
//		int rental_id = session.getAttribute("selectedRental")
//		
//		Rental rental = new Rental();
//		rental.setRental_id(rental_id);
		
		int result = rentalDao.updateRental(conn, rental);
		
		request.setAttribute("result", result);
		
		JDBCCloser.close(conn);
		
		request.getRequestDispatcher(resultPath).forward(request, response);
		
	}
}
