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
		MemberDAO memberDAO = MemberDAO.getInstance(); //�̱���
		
		//�Է��� ���̵� �н����带 ��ǲ��� ��ü�� ����
		Member inputmember = new Member();	
		inputmember.setMember_id(request.getParameter("member_id"));
		inputmember.setMember_password(request.getParameter("member_password"));
		
		//�Է��� ���� DB�� ����� ���� ��ġ�ϸ� �α��� ��Ű���� ����
		Member member = memberDAO.selectMember(conn, inputmember.getMember_id());
		if(member == null || !member.getMember_password().equals(inputmember.getMember_password())) {
			//�α��� ����
			request.setAttribute("result", 0);
		}else {
			//�α��� ����
			request.setAttribute("result", 1);
			//�α��� ���θ� ���� ��ü�� ����
			HttpSession session = request.getSession();
			session.setAttribute("isLogin", true); //�α����� �Ǿ����� ��
			session.setAttribute("loginMember", member); //�α��� �� ��� ��ü
		}
		
		JDBCCloser.close(conn);
		
		request.getRequestDispatcher(resultPath).forward(request, response);
	}

}
