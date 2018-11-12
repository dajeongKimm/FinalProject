package mvc.action;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.dao.*;
import mvc.model.*;
import mvc.util.*;

public class LoginAction implements Action{
	
	private static final String formPath = "/jsp/loginMember.jsp";
	private static final String resultPath = "/jsp/loginMemberResult.jsp";
	
	

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("GET")) {
			request.getRequestDispatcher(formPath).forward(request, response);
		}else {
			doPost(request, response);
		}
	}

	private void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = JDBCConnection.getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance(); //싱글턴
		
		//입력한 아이디 패스워드를 인풋멤버 객체에 저장
		Member inputmember = new Member();	
		inputmember.setMember_id(request.getParameter("member_id"));
		inputmember.setMember_password(request.getParameter("member_password"));
		
		//입력한 값과 DB에 저장된 값이 일치하면 로그인 시키려는 로직
		Member member = memberDAO.selectMember(conn, inputmember.getMember_id());
		if(member == null || !member.getMember_password().equals(inputmember.getMember_password())) {
			//로그인 실패
			request.setAttribute("result", 0);
		}else {
			//로그인 성공
			request.setAttribute("result", 1);
			//로그인 여부를 세션 객체에 저장
			HttpSession session = request.getSession();
			session.setAttribute("isLogin", true); //로그인이 되었으면 참
			session.setAttribute("loginMember", member); //로그인 된 멤버 객체
		}
		
		JDBCCloser.close(conn);
		
		request.getRequestDispatcher(resultPath).forward(request, response);
	}

}
