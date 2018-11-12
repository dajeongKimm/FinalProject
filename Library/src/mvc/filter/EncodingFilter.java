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
		//�� �����̳ʷ� ���޵Ǵ� ��� �ܺ��� ��û ��ü�� ���� ���ڵ��� utf-8 �� �����ϴ� ����
		// (��� ������ JSP ������ ) ���Ϳ��� ������ ĳ���� ���ڵ� �� �����͸� ���� �� �ֽ��ϴ�.)
		request.setCharacterEncoding(strEncoding);
		chain.doFilter(request, response);
	}

	

}
