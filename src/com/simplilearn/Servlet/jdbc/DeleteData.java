package com.simplilearn.Servlet.jdbc;

import java.io.IOException;
import java.io.InputStream;
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
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
		Properties prop = new Properties();
		prop.load(in);
		 
			JdbcUtil db = new JdbcUtil(prop.getProperty("url"), prop.getProperty("userid"), prop.getProperty("password"));
			int uid = Integer.parseInt(request.getParameter("uid"));
			PreparedStatement preparedStatement = db.getConnection().prepareStatement("delete from tbl_user2 where uid=?");
			preparedStatement.setInt(1, uid);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			db.closeConnection();
			response.sendRedirect("select");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

 
}
