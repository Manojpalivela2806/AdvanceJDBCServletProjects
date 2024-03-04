package com.jsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.EmployeeDao;
import com.jsp.dao.EmployeeDaoImpl;
import com.jsp.model.EmployeeJ;
@WebServlet("/upbyid")
public class EmployeeDetailsById extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		
		String parameter = request.getParameter("upd");	
		int empid=Integer.parseInt(parameter);
		

		
		EmployeeDao dao = new EmployeeDaoImpl();
			EmployeeJ employeeById = dao.getEmployeeById(empid);
			
			
		if (employeeById!=null) {
			session.setAttribute("empldetails", employeeById);
			RequestDispatcher rd = request.getRequestDispatcher("UpdateDetails.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("null.html");
			rd.forward(request, response);
		}
		
	}

}
//themleaf or jstl for to write java code in html page.