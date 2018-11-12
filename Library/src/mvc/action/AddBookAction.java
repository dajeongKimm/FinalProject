package mvc.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import mvc.dao.*;
import mvc.model.*;
import mvc.util.*;

public class AddBookAction implements Action {

	private static final String formPath = "/jsp/addBook.jsp";
	private static final String resultPath = "/jsp/addBookResult.jsp";

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getMethod().equals("GET")) {
			request.getRequestDispatcher(formPath).forward(request, response);
		} else if (request.getMethod().equals("POST")) {
			doPost(request, response);
		}
	}

	private void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String saveDir = request.getServletContext().getInitParameter("saveDirectory");

		// 현재 구동중인 경로
		saveDir = request.getServletContext().getRealPath(saveDir);

		// 파일 읽어오기
		if (request.getPart("file").getSize() != 0) {
			Part filePart = request.getPart("file");
			String originFileName = getFileName(filePart); // 원본파일 ex)ajlkjl.jpg

			// 난수 발생시킨 이름으로 파일명 저장시키기
			Random random = new Random();
			String fileName = "image_" + random.nextLong() + originFileName.substring(originFileName.indexOf(".")); // image_53775.jpg

			// 설정한 경로 saveDir => upload/image 에 이미지 파일 저장
			File dir = new File(saveDir);
			if (!dir.exists())
				dir.mkdirs();
			File file = new File(dir, fileName);

			// 파일 읽어오기
			BufferedInputStream bis = new BufferedInputStream(filePart.getInputStream());
			// 파일 내보내기
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));

			byte[] data = new byte[1024];

			while (bis.read(data) != -1) {
				bos.write(data);
			}

			bis.close();
			bos.close();

			
			
			Connection conn = JDBCConnection.getConnection();

			BookDAO bookDao = BookDAO.getInstance();
			Book book = new Book();
			book.setBook_title(request.getParameter("book_title"));
			book.setBook_author(request.getParameter("book_author"));
			book.setBook_publisher(request.getParameter("book_publisher"));
			book.setBook_price(Double.parseDouble(request.getParameter("book_price")));
			String temp = request.getServletContext().getInitParameter("saveDirectory");
			temp = temp + "/" + fileName; // ex temp = upload/image/image_ajjljl.jpg
			book.setBook_image(temp);
				
			int result = bookDao.insertBook(conn, book);
				
			request.setAttribute("result", result);
			//HttpSession session = request.getSession();
			//session.setAttribute("bookImagePath", originFileName);
			
			JDBCCloser.close(conn);
			
			request.getRequestDispatcher(resultPath).forward(request, response);
		}
	}
	
	public String getFileName(Part filePart) {
		for (String filePartData : filePart.getHeader("Content-Disposition").split(";")) {
			//System.out.println(filePartData);
			if (filePartData.trim().startsWith("filename")) {
				return filePartData.substring(filePartData.indexOf("=") + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	/*
	 * private void doPost(HttpServletRequest request, HttpServletResponse response)
	 * throws ServletException, IOException { Connection conn =
	 * JDBCConnection.getConnection();
	 * 
	 * BookDAO bookDao = BookDAO.getInstance(); Book book = new Book();
	 * book.setBook_title(request.getParameter("book_title"));
	 * book.setBook_author(request.getParameter("book_author"));
	 * book.setBook_publisher(request.getParameter("book_publisher"));
	 * book.setBook_price(Double.parseDouble(request.getParameter("book_price")));
	 * book.setBook_image(request.getParameter("book_image"));
	 * 
	 * //jsp의 form태그 속성중 enctype = "multipart/form-data" 속성을 사용하면 위와같은 방식으로 파라미터를
	 * 받아올 수 없다. //MultipartRequest를 사용하여 가져오기.
	 * 
	 * 
	 * int result = bookDao.insertBook(conn, book);
	 * 
	 * request.setAttribute("result", result);
	 * 
	 * JDBCCloser.close(conn);
	 * 
	 * request.getRequestDispatcher(resultPath).forward(request, response); }
	 */

}
