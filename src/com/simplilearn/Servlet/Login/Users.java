package com.simplilearn.Servlet.Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class User
 */
@WebServlet("/Users")
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		/*
		 * RequestDispatcher req = null; if (username.equalsIgnoreCase("Admin") &&
		 * password.equals("admin123")) { req =
		 * request.getRequestDispatcher("SuccessServlet"); //req =
		 * request.getRequestDispatcher("LogoutServlet"); req.forward(request,
		 * response); } else { req = request.getRequestDispatcher("index.html");
		 * PrintWriter out = response.getWriter(); req.include(request, response); out.
		 * println("<center> <span style = color:red > Invalid Credential!!</span></center>"
		 * );
		 * 
		 * }
		 */

		if (username.equalsIgnoreCase("Admin") && password.equals("admin123")) {
			out.print("You are successfully logged in!");
			out.print("<br>Welcome, " + username);

			HttpSession session=request.getSession();
			session.setAttribute("username",username);
		} else {
			out.println("<center> <span style = color:red > Invalid Credential!!</span></center>");
			request.getRequestDispatcher("login.html").include(request, response);
		}

	}

}
