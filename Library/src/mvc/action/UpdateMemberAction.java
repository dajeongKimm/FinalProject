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

public class UpdateMemberAction implements Action {

	private static final String formPath = "/jsp/updateMember.jsp";
	private static final String resultPath = "/jsp/updateMemberResult.jsp";

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getMethod().equals("GET")) {
			request.getRequestDispatcher(formPath).forward(request, response);
		} else {
			doPost(request, response);
		}
	}

	private void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String member_id = request.getParameter("member_id");
		String member_password = request.getParameter("member_password");
		String saveDir = request.getServletContext().getInitParameter("saveDirectory_member");

		// ���� �������� ���
		saveDir = request.getServletContext().getRealPath(saveDir);

		Connection conn = JDBCConnection.getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		HttpSession session = request.getSession();
	
		// �α��� �ϰ� ȸ������ �����ϱ�
		Member inputMember = memberDAO.selectMember(conn, member_id);
		int result = 0;
		Member newMember = null; //������ ��� ���� �����ų ��ü
		

		if (inputMember == null || !inputMember.getMember_password().equals(member_password)) { // �α��� �����Ͽ� ȸ������ ���� �� �� ����.	
			result = 0;
		} else { // �α��� �����Ͽ� ȸ������ ���� �� �� ����.
			// ���� �о����
			if (request.getPart("file").getSize() != 0) {
				Part filePart = request.getPart("file");
				String originFileName = getFileName(filePart); // �������� ex)ajlkjl.jpg
				System.out.println("1111");
				// ���� �߻���Ų �̸����� ���ϸ� �����Ű��
				Random random = new Random();
				String fileName = "image_" + random.nextLong() + originFileName.substring(originFileName.indexOf(".")); // image_53775.jpg

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

				newMember = new Member();
				newMember.setMember_id(member_id);
				newMember.setMember_password(inputMember.getMember_password());
				newMember.setMember_name(request.getParameter("member_name"));
				newMember.setMember_type(inputMember.getMember_type());
				newMember.setMember_age(Integer.parseInt(request.getParameter("member_age")));
				newMember.setMember_tel(request.getParameter("member_tel"));
				newMember.setMember_address(request.getParameter("member_address"));
				newMember.setMember_email(request.getParameter("member_email"));
				newMember.setMember_gender(request.getParameter("member_gender"));
				String temp = request.getServletContext().getInitParameter("saveDirectory_member");
				temp = temp + "/" + fileName; // ex temp = upload/image/image_ajjljl.jpg
				newMember.setMember_photo(temp);

				result = memberDAO.updateMember(conn, newMember);
				System.out.println(result);
				
				//����� ������ �α����� ��ü�� �ٲ�
				
				session.setAttribute("loginMember", newMember);
			}else {//���� ���ٸ�
				newMember = new Member();
				newMember.setMember_id(member_id);
				newMember.setMember_password(inputMember.getMember_password());
				newMember.setMember_name(request.getParameter("member_name"));
				newMember.setMember_type(inputMember.getMember_type());
				newMember.setMember_age(Integer.parseInt(request.getParameter("member_age")));
				newMember.setMember_tel(request.getParameter("member_tel"));
				newMember.setMember_address(request.getParameter("member_address"));
				newMember.setMember_email(request.getParameter("member_email"));
				newMember.setMember_gender(request.getParameter("member_gender"));
				newMember.setMember_photo(inputMember.getMember_photo());

				result = memberDAO.updateMember(conn, newMember);
				System.out.println(result);
				
				//����� ������ �α����� ��ü�� �ٲ�
				
				session.setAttribute("loginMember", newMember);
			}
		}

		request.setAttribute("result", result);
			
		JDBCCloser.close(conn);

		request.getRequestDispatcher(resultPath).forward(request, response);
	}
	
	public String getFileName(Part filePart) {
		for (String filePartData : filePart.getHeader("Content-Disposition").split(";")) {
			if (filePartData.trim().startsWith("filename")) {
				return filePartData.substring(filePartData.indexOf("=") + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}
