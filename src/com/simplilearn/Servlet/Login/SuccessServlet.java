package com.simplilearn.Servlet.Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SuccessServlet
 */
@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuccessServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		HttpSession session = request.getSession(false);
		if (session != null) {
			int uid = (Integer) session.getAttribute("uid");

			out.print("Hello, " + uid + " Welcome to Profile");
		} else {
			out.print("Please login first");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * PrintWriter out = response.getWriter();
		 * //out.print("You are successfully logged in!"); out.print("<h4>Welcome, " +
		 * request.getParameter("username") +"<br>" +"You are successfully logged in " +
		 * new Date() +"</h4>"); PrintWriter out=response.getWriter();
		 */
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);

		HttpSession session = request.getSession(false);
		if (session != null) {
			String username = (String) session.getAttribute("username");

			out.print("Hello, " + username + " Welcome to Profile");
		} else {
			out.print("Please login first");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}

}
