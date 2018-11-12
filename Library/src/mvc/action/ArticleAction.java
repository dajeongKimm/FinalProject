package mvc.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import mvc.dao.*;
import mvc.model.*;
import mvc.util.*;

public class ArticleAction implements Action{
	
	private static final String formPath = "/jsp/article.jsp";
	

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("GET")) {
			Connection conn = JDBCConnection.getConnection();
			
			//한 페이지에 보이는 article의 개수
			int count = 10;
			int startIndex = 0;
			int page = 1;
			
			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
				startIndex = (page - 1) * count;
			}
			
			ArticleDAO articleDao = ArticleDAO.getInstance();
			ArrayList<Article> article = articleDao.selectAllArticle(conn, startIndex, count);
			
			int recordCount = articleDao.getRecordCount(conn);
			int totalPage = recordCount / count + (recordCount % count != 0 ? 1:0);
			
			int pageCount = 10;
			int startPage=(page-1) / pageCount * pageCount;
			
			if(startPage % pageCount == 0)
				startPage += 1;
			
			int endPage = startPage + pageCount -1 ;
			
			if(endPage > totalPage)
				endPage = totalPage;
			
			request.setAttribute("page", page);
			request.setAttribute("article", article);
			request.setAttribute("startIndex", startIndex);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			
			request.getRequestDispatcher(formPath).forward(request, response);
		}
	}
}
