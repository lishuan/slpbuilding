package com.slp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class myFilter implements Filter {

	public void init(FilterConfig config) throws ServletException {
	}

	@Override
	public void destroy() {
		// TODO 自动生成的方法存根

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "*");
		response.addHeader("Access-Control-Max-Age", "3600");
		response.addHeader("Access-Control-Allow-Headers", "*");
		/*
		 * String path = request.getServletPath(); path = path.toLowerCase();
		 * String url = request.getContextPath(); HttpSession session =
		 * ((HttpServletRequest) request).getSession(); if
		 * (path.indexOf("/admin/") >= 0) { if (session.getAttribute("admin") ==
		 * null) { response.sendRedirect(url + "/home/adminlogin.html"); return;
		 * }
		 * 
		 * } if (path.indexOf("/member/") >= 0) { if
		 * (session.getAttribute("member") == null) { response.sendRedirect(url
		 * + "/home/memberlogin.html"); return; }
		 * 
		 * } if (path.indexOf("/agent/") >= 0) { if
		 * (session.getAttribute("agent") == null) { response.sendRedirect(url +
		 * "/home/agentlogin.html"); return; }
		 * 
		 * }
		 */
		arg2.doFilter(request, response);

	}

}
