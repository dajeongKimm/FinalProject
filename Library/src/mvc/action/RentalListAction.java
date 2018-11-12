package mvc.action;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.dao.RentalDAO;
import mvc.model.Member;
import mvc.model.Rental;
import mvc.util.JDBCConnection;

public class RentalListAction implements Action{
	
	private static final String resultPath = "/jsp/rentalList.jsp";

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = JDBCConnection.getConnection();
		//로그인된 아이디 가져오기
		// 전에 세션객체에 넣어놔서 GET으로 가져옴.
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginMember");
		String member_id = member.getMember_id();
		
		RentalDAO rentalDao = RentalDAO.getInstance();
		ArrayList<Rental> rental  = rentalDao.selectRental(conn, member_id);
		
		request.setAttribute("rental", rental);
		
		request.getRequestDispatcher(resultPath).forward(request, response);
	}

	
}
