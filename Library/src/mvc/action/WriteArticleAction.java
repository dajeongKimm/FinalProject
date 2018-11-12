package mvc.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import mvc.dao.*;
import mvc.model.*;
import mvc.util.*;

public class WriteArticleAction implements Action {

	private static final String formPath = "/jsp/writeArticle.jsp";
	private static final String resultPath = "/jsp/articleWriteResult.jsp";

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getMethod().equals("POST")) {
			doPost(request, response);
		}else {
			request.getRequestDispatcher(formPath).forward(request, response);
		}

	}

	private void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = JDBCConnection.getConnection();

		ArticleDAO articleDao = ArticleDAO.getInstance();
		Article article = new Article();
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");

		article.setMember_id(loginMember.getMember_id());
		article.setMember_name(loginMember.getMember_name());
		article.setTitle(request.getParameter("title"));
		article.setContents(request.getParameter("contents"));

		int result = articleDao.insertMember(conn, article);

		request.setAttribute("result", result);

		JDBCCloser.close(conn);

		request.getRequestDispatcher(resultPath).forward(request, response);

	}

}
