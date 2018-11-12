package mvc.action;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.dao.*;
import mvc.model.*;
import mvc.util.*;

public class SearchBookAction implements Action{
	
	private static final String formPath = "/jsp/allBookList.jsp";
	
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("POST")) {
			doPost(request, response);
		}
	}

	private void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = JDBCConnection.getConnection();
		
		BookDAO bookDao = BookDAO.getInstance();
		
		ArrayList<Book> book = null;
		String target = null;
		String value = request.getParameter("key").trim();
		
		if(request.getParameter("searchKey").equals("��ü")) {
			target = null;
		}else if(request.getParameter("searchKey").equals("Ÿ��Ʋ")) {
			target = "book_title";
		}else if(request.getParameter("searchKey").equals("����")) {
			target = "book_author";
		}else if(request.getParameter("searchKey").equals("���ǻ�")) {
			target = "book_publisher";
		}
		
		if(target == null) {
			book = bookDao.selectBookUsingCondition(conn, value);
		}else {
			book = bookDao.selectBookUsingCondition(conn, target, value);
		}
		
		request.setAttribute("book", book);
		
		JDBCCloser.close(conn);
		
		request.getRequestDispatcher(formPath).forward(request, response);
	}

}
