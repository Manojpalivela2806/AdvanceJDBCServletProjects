package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
@WebServlet("/allemp")
public class AllEmployeeDetails extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
//		PrintWriter writer = response.getWriter();
		EmployeeDao dao = new EmployeeDaoImpl();
			List<EmployeeJ> allEmployees = dao.getAllEmployees();
			session.setAttribute("listofemployees", allEmployees);
		RequestDispatcher dp = request.getRequestDispatcher("Employee.jsp");		
		dp.forward(request, response);	
	}

}
