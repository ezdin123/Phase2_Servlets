package com.simplilearn.Servlet.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.Servlet.Login.JdbcUtil;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertData() {
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
		Properties prop = new Properties();
		prop.load(in);
		
			PrintWriter out = response.getWriter();  
			JdbcUtil db = new JdbcUtil(prop.getProperty("url"), prop.getProperty("userid"),prop.getProperty("password"));
			PreparedStatement pstmt = db.getConnection().prepareStatement("insert into tbl_user2 (username, password, fname, gender) values (?,?,?,?)");
			pstmt.setString(1, request.getParameter("username"));
			pstmt.setString(2, request.getParameter("password"));
			pstmt.setString(3, request.getParameter("fname"));
			pstmt.setString(4, request.getParameter("gender"));
		 

			int i =pstmt.executeUpdate();
			 if(i>0) out.print("You are successfully registered...");
			 pstmt.close();

			 db.closeConnection();
			response.sendRedirect("select");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
