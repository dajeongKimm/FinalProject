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
import mvc.model.Member;
import mvc.model.Rental;
import mvc.model.Reservation;
import mvc.util.JDBCConnection;

public class ReservationListAction implements Action{
	
	private static final String resultPath = "/jsp/reservationList.jsp";

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = JDBCConnection.getConnection();
		//�α��ε� ���̵� ��������
		// ���� ���ǰ�ü�� �־���� GET���� ������.
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginMember");
		String member_id = member.getMember_id();
		
		ReservationDAO reservationDao = ReservationDAO.getInstance();
		ArrayList<Reservation> reservation = reservationDao.selectReservation(conn, member_id);
		
		request.setAttribute("reservation", reservation);
		
		request.getRequestDispatcher(resultPath).forward(request, response);
	}
}
