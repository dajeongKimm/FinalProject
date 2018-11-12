package mvc.action;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.dao.RentalDAO;
import mvc.model.Rental;
import mvc.util.JDBCCloser;
import mvc.util.JDBCConnection;

public class AllRentalListAction implements Action{
	
	private static final String resultPath = "/jsp/allRentalList.jsp";

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("GET")) {
			doGet(request, response);
		}
	}

	private void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = JDBCConnection.getConnection();
		
		RentalDAO rentalDao = RentalDAO.getInstance();
		ArrayList<Rental> rental = rentalDao.selectRental(conn);
		
		JDBCCloser.close(conn);
		
		request.setAttribute("rental", rental);
		
		request.getRequestDispatcher(resultPath).forward(request, response);
	}
}
