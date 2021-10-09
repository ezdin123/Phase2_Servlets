package com.simplilearn.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Login implements Servlet {
	ServletConfig config;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet init");
		this.config = config;
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();

//		if (username.isEmpty() || password.isEmpty()) {
//			RequestDispatcher req = request.getRequestDispatcher("errorpage.html");
//			req.include(request, response);
//		} else {
//			RequestDispatcher req = request.getRequestDispatcher("index.html");
//			req.forward(request, response);
//		}

		out.println("<html><body>");
		out.println("Your full name is " + username + " " + password);
		out.println("</body></html>");
		
		System.out.println(getServletConfig().getInitParameterNames());
	}

}
