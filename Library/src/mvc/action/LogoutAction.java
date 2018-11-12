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

public class LogoutAction implements Action{
	
	private static final String formPath = "";
	private static final String resultPath = "/login";
	

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.removeAttribute("isLogin");
		session.removeAttribute("loginMember");
		
		response.sendRedirect(request.getContextPath() + resultPath);
		
	}
}
