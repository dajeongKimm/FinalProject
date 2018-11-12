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

public class RegistAction implements Action{
	
	private static final String formPath = "/jsp/registMember.jsp";
	private static final String resultPath = "/jsp/registMemberResult.jsp";
	

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("GET")) {
			request.getRequestDispatcher(formPath).forward(request, response);
		}else {
			doPost(request, response);
		}
	}
	
	private void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String saveDir = request.getServletContext().getInitParameter("saveDirectory_member");

		// ���� �������� ���
		saveDir = request.getServletContext().getRealPath(saveDir);

		// ���� �о����
		if (request.getPart("file").getSize() != 0) {
			Part filePart = request.getPart("file");
			String originFileName = getFileName(filePart); // �������� ex)ajlkjl.jpg

			// ���� �߻���Ų �̸����� ���ϸ� �����Ű��
			Random random = new Random();
			String fileName = "memberImage_" + random.nextLong() + originFileName.substring(originFileName.indexOf(".")); // image_53775.jpg

			// ������ ��� saveDir => upload/image �� �̹��� ���� ����
			File dir = new File(saveDir);
			if (!dir.exists())
				dir.mkdirs();
			File file = new File(dir, fileName);

			// ���� �о����
			BufferedInputStream bis = new BufferedInputStream(filePart.getInputStream());
			// ���� ��������
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));

			byte[] data = new byte[1024];

			while (bis.read(data) != -1) {
				bos.write(data);
			}

			bis.close();
			bos.close();

			
			Connection conn = JDBCConnection.getConnection();
			
			MemberDAO memberDAO = MemberDAO.getInstance();
			
			Member member = new Member();
			member.setMember_id(request.getParameter("member_id"));
			member.setMember_password(request.getParameter("member_password"));
			member.setMember_name(request.getParameter("member_name"));
			member.setMember_age(Integer.parseInt(request.getParameter("member_age")));
			member.setMember_tel(request.getParameter("member_tel"));
			member.setMember_address(request.getParameter("member_address"));
			member.setMember_email(request.getParameter("member_email"));
			member.setMember_gender(request.getParameter("member_gender"));
			String temp = request.getServletContext().getInitParameter("saveDirectory_member");
			temp = temp + "/" + fileName; // ex temp = upload/image/image_ajjljl.jpg
			member.setMember_photo(temp);
			
			int result = memberDAO.insertMember(conn, member);
				
			request.setAttribute("result", result);
			
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
	private void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = JDBCConnection.getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		Member member = new Member();
		member.setMember_id(request.getParameter("member_id"));
		member.setMember_password(request.getParameter("member_password"));
		member.setMember_name(request.getParameter("member_name"));
		member.setMember_age(Integer.parseInt(request.getParameter("member_age")));
		member.setMember_tel(request.getParameter("member_tel"));
		member.setMember_address(request.getParameter("member_address"));
		member.setMember_email(request.getParameter("member_email"));
		member.setMember_gender(request.getParameter("member_gender"));
		member.setMember_photo(request.getParameter("file"));
		
		int result = memberDAO.insertMember(conn, member);
		request.setAttribute("result", result);
		
		
		JDBCCloser.close(conn);
		
		request.getRequestDispatcher(resultPath).forward(request, response);
	
	}
	*/

}
