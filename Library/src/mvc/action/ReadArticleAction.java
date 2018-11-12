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

public class ReadArticleAction implements Action {

	private static final String formPath = "/jsp/readArticle.jsp";
	//private static final String resultPath = "/jsp/updateResult.jsp";

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getMethod().equals("GET")) {
			doGet(request, response);
		}

	}

	private void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = JDBCConnection.getConnection();

		ArticleDAO articleDao = ArticleDAO.getInstance();
		int article_no = Integer.parseInt(request.getParameter("article_no"));
		Article article = articleDao.selectArticle(conn, article_no);
		articleDao.increaseReadCount(conn, article_no); //읽을때마다 조회수 증가

		request.setAttribute("article", article);

		JDBCCloser.close(conn);

		request.getRequestDispatcher(formPath).forward(request, response);
	}
}
