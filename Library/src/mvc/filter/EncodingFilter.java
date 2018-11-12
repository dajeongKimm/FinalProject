package mvc.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;


@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/*" }
					, initParams = {@WebInitParam(name="encoding", value="utf-8")} )
public class EncodingFilter implements Filter {
	private String strEncoding = null;
	public void init(FilterConfig fConfig) throws ServletException {
		strEncoding = fConfig.getInitParameter("encoding");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//웹 컨테이너로 전달되는 모든 외부의 요청 객체의 문자 인코딩을 utf-8 로 지정하는 필터
		// (모든 서블릿과 JSP 에서는 ) 필터에서 지정한 캐릭터 인코딩 된 데이터를 받을 수 있습니다.)
		request.setCharacterEncoding(strEncoding);
		chain.doFilter(request, response);
	}

	

}
