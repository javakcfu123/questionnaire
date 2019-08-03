package com.javakc.questionnaire.util.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(urlPatterns= {"*.do","*.jsp"})
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("LoginFilter======");
		HttpServletRequest req = (HttpServletRequest) request;
		// �ж��û��Ƿ��¼
		HttpSession session = req.getSession(false);
		boolean b = false;// û�е�¼
		
		if(session!=null) {
			Object o=session.getAttribute("user_name");
			if(o!=null) {
				b=true;
			}
		}
		if (b) {
			// ��¼��
			chain.doFilter(request, response);
		} else {
			// û�е�¼,��ת����¼ҳ��
			req.getRequestDispatcher("/login.jsp").forward(request, response);
		
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
