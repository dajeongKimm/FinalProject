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

public class AllBookListAction implements Action{
	
	private static final String formPath = "/jsp/allBookList.jsp";
	
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("GET")) {
			doGet(request, response);
		}
	}

	private void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = JDBCConnection.getConnection();
		
		BookDAO bookDao = BookDAO.getInstance();
		ArrayList<Book> book = bookDao.selectAllBook(conn);
		
		request.setAttribute("book", book);
		
		JDBCCloser.close(conn);
		
		request.getRequestDispatcher(formPath).forward(request, response);
	}

}
