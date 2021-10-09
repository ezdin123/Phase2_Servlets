package com.simplilearn.mySql;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Select
 */
@WebServlet("/Select")
public class SelectData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*nputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");

		Properties prop = new Properties();

		prop.load(in);*/

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/databasename?user=root&password=Manal@0930"); 
			String uid = request.getParameter("uid");
 
			/*
			 * JdbcUtil db = new JdbcUtil(prop.getProperty("url"), prop.getProperty("user"),
			 * prop.getProperty("password"));
			 */
			  Statement stmt =con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			  ResultSet rSet = stmt.executeQuery("select * from tbl_user2 where  uid='"+uid+"' ");
			response.getWriter().print("<html><body>");
			PrintWriter out = response.getWriter() ;
			if (rSet.next()) {
				out.println("<div> <span style = color:red >User Details</span></div>"); 
				out.println("User_ID :  " + rSet.getInt(1) + "  User_Name:  " + rSet.getString(2) + " Password:  "
						+ rSet.getString(3) + "  Full_Name :  " + rSet.getString(4) + "  ");
						System.out.println("uid"+ uid);
			}else {
				out.println("<div> <span style = color:red >You have entered an invalid user ID</span></div>"); 
				 
			}

			response.getWriter().print("</body></html>");

			stmt.close();
			con.close();
			//db.closeConnection();

		} catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
 

}
