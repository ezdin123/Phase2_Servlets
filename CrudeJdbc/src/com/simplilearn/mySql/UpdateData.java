package com.simplilearn.mySql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//			InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
//			Properties props = new Properties();
//			props.load(in);
			// Open a connection
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				 
				Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost/databasename?user=root&password=Manal@0930");
			//JdbcUtil conn = new JdbcUtil(props.getProperty("url"), props.getProperty("userid"),props.getProperty("password"));
			
			int uid = Integer.parseInt(request.getParameter("uid"));
			String uname = request.getParameter("new_username");
			
			PreparedStatement st = conn.prepareStatement("update tbl_user2 set username=? where uid=?  ");
			st.setString(1, uname);
			st.setInt(2, uid);
				st.executeUpdate();
				//conn.closeConnection();
				conn.close();
				response.sendRedirect("select");
		} catch (Exception e) {
		}

	}

}
