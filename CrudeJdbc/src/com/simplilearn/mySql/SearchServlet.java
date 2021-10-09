package com.simplilearn.mySql;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Search;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Search.date = request.getParameter("date");
		Search.source = request.getParameter("source");
		Search.destination = request.getParameter("destination");
		Search.persons = Integer.parseInt(request.getParameter("persons"));

		if (Search.date.equals("")) {
			PrintWriter out = response.getWriter();
			out.println("Please enter a valid date");
		} else {
			Search.day = getDay(Search.date);
			response.sendRedirect("/search-results.jsp");
		}
	}

	public String getDay(String dateInp) {
		LocalDate dt = LocalDate.parse(dateInp);
		return dt.getDayOfWeek().toString();
	}

}
