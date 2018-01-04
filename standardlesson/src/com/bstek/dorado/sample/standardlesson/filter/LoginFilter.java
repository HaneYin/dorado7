package com.bstek.dorado.sample.standardlesson.filter;

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

import com.bstek.dorado.sample.standardlesson.entity.SlEmployee;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		SlEmployee employee = (SlEmployee) session.getAttribute("user");
		if (employee != null) {
			filter.doFilter(request, response);
		} else if (!req.getRequestURI().endsWith("Login.d")){
			res.sendRedirect(req.getContextPath() + "/com.bstek.dorado.sample.standardlesson.middle.Login.d");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
