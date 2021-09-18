package com.simplilearn.Servlet.Login;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		
		
		try {
		
			InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
			Properties props = new Properties();
			props.load(in);
			// Open a connection
			JdbcUtil conn = new JdbcUtil(props.getProperty("url"), props.getProperty("userid"),
					props.getProperty("password"));
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Statement st = conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rSet = st.executeQuery("select * from tbl_user where  username='"+username+"' and password = '"+password+"' ");
			System.out.println(rSet.toString().valueOf(username));
			
		 PrintWriter out = response.getWriter() ;
			if( rSet.next()  ) {
				request.getRequestDispatcher("link.html").include(request, response);
				int uid = rSet.getInt("uid");
				out.println("<h2>You are successfully logged in!</h2>" + new Date()); 
				System.out.println("<br>Welcome, " + uid);
				HttpSession session=request.getSession();
				session.setAttribute("logged", true);
				session.setAttribute("uid", uid);
				//session.setAttribute("username",username);
			
			} else {
			out.println("<center> <span style = color:red > Invalid Credential!!</span></center>"); 
				request.getRequestDispatcher("login.html").include(request, response);
				//response.sendRedirect("error.html");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		// PrintWriter out = response.getWriter() ;
		
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
		
		

	}

}
