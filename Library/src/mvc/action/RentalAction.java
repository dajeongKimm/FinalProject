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
import mvc.util.JDBCConnection;

public class RentalAction implements Action{
	
	private static final String resultPath = "/jsp/rentalResult.jsp";

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("POST")) {
			doPost(request, response);
		}
		
	}

	private void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = JDBCConnection.getConnection();
		//�α��ε� ���̵� ��������
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginMember");
		String member_id = member.getMember_id();
		String member_name = member.getMember_name();
		//���õ� å���� ��������
		Book book = (Book)session.getAttribute("selectedBook");
		int book_id = book.getBook_id();
		String book_title = book.getBook_title();
		
		RentalDAO rentalDao = RentalDAO.getInstance();
		
		//insert�� rental ��ü ����
		Rental rental = new Rental();
		rental.setMember_id(member_id);
		rental.setMember_name(member_name);
		rental.setBook_id(book_id);
		rental.setBook_title(book_title);
		//insert �ϱ�
		int result = rentalDao.insertRental(conn, rental);
		
		
		
		
		request.setAttribute("result", result);
		
		request.getRequestDispatcher(resultPath).forward(request, response);
		
	}
}
