package mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.*;
import mvc.action.*;

@WebServlet(urlPatterns= {"/"}, loadOnStartup=1)
@MultipartConfig
public class ControllerServletUsingProperties extends HttpServlet {
	
	private HashMap<String, Action> actionMap;
	
	public void init() throws ServletException {
		// 키=밸류 형태로 구성된 파일로부터 데이터를
		// 읽을 수 있는 자료구조 클래스
		Properties prop = new Properties();		
		// 웹 어플리케션이 실제로 구동 중인 경로를 추출하는 과정
		String filePath = "/WEB-INF/UriMappingInfo.properties";
		filePath = getServletContext().getRealPath(filePath);
		File file = new File(filePath);
		
		try (FileReader reader = new FileReader(file)) {
			prop.load(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		actionMap = new HashMap<>();
		
		Enumeration<Object> enu = prop.keys();
		while( enu.hasMoreElements() ) {
			String key = (String)enu.nextElement();
			String value = prop.getProperty(key);
			
			try {
				Class<?> object = Class.forName(value);
				Action action = (Action)object.newInstance();				
				actionMap.put(key, action);
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		uri = uri.substring(request.getContextPath().length());		
		
		Action action = null;
		action = actionMap.get(uri);
		
		if( action != null )
			action.excute(request, response); 
	}
	

}








