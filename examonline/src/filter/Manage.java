package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Manage implements Filter {

	@Override
	public void destroy() {
		System.out.println("销毁");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("执行前");
		HttpServletRequest request=(HttpServletRequest) arg0;
		HttpServletResponse reponse=(HttpServletResponse) arg1;
		HttpSession session=request.getSession();
		if(session.getAttribute("username")==null){
			reponse.sendRedirect(request.getContextPath()+"/index.html");
		}
		else{
		arg2.doFilter(arg0, arg1);
		System.out.println("执行后");
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("初始化");
	}

}
