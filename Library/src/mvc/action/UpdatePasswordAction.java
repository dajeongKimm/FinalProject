package mvc.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import javafx.scene.control.Alert;
import mvc.dao.*;
import mvc.model.*;
import mvc.util.*;

public class UpdatePasswordAction implements Action {

	private static final String formPath = "/jsp/updatePassword.jsp";
	private static final String resultPath = "/jsp/updatePasswordResult.jsp";

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getMethod().equals("GET")) {
			request.getRequestDispatcher(formPath).forward(request, response);
		} else {
			doPost(request, response);
		}
	}

	private void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = JDBCConnection.getConnection();

		MemberDAO memberDAO = MemberDAO.getInstance();

		String id = request.getParameter("member_id");
		String pwd = request.getParameter("member_password");
		String newPassword = request.getParameter("newPassword");
	

		// 로그인 하고 회원정보 수정하기
		Member inputMember = memberDAO.selectMember(conn, id);

		int result = 0;
		Member newMember = null;

		if (inputMember == null || !inputMember.getMember_password().equals(pwd)) {
			// 로그인 실패하여 회원정보 수정 할 수 없음.
			result = 0;
		} else { // 로그인 성공하여 회원정보 수정 할 수 있음.	
			result = memberDAO.updateMember(conn, inputMember, newPassword);
		}
		
		request.setAttribute("result", result);	

		JDBCCloser.close(conn);

		request.getRequestDispatcher(resultPath).forward(request, response);
		
	}
}
