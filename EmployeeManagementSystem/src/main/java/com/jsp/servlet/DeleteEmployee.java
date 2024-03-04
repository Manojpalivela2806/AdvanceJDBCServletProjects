package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dao.EmployeeDao;
import com.jsp.dao.EmployeeDaoImpl;
@WebServlet("/delbyId")
public class DeleteEmployee extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parameter2 = request.getParameter("del");
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		int deempid=Integer.parseInt(parameter2);	
		EmployeeDao dao = new EmployeeDaoImpl();
		int deleteEmployee = dao.deleteEmployee(deempid);
		if(deleteEmployee!=0)
		{
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
			writer.println("<center><h2>employee with id :"+deempid+" deleted click on above button to check</h2><center>");
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("null.html");
			rd.forward(request, response);
		}
	}

}
