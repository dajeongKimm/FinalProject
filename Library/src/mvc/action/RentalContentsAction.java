package mvc.action;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.dao.RentalDAO;
import mvc.util.JDBCConnection;

public class RentalContentsAction implements Action{
	
	private static final String resultPath = "/jsp/rentalContents.jsp";

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("GET")) {
			doGet(request, response);
		}
	}

	private void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = JDBCConnection.getConnection();
		
		RentalDAO rentalDao = RentalDAO.getInstance();
		
		
		request.getRequestDispatcher(resultPath).forward(request, response);
	}
}
