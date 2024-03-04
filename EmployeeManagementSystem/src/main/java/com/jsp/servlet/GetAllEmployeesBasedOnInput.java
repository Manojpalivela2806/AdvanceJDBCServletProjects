package com.jsp.servlet;

import java.io.IOException;
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
@WebServlet("/search")
public class GetAllEmployeesBasedOnInput extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String parameter = request.getParameter("dept");
		double num=Double.parseDouble(parameter);		
		EmployeeDao dao = new EmployeeDaoImpl();
		List<EmployeeJ> SalaryOrDeptno = dao.getAllEmployeesByparamater(num);
		if(SalaryOrDeptno!=null) {
			session.setAttribute("listofemployees", SalaryOrDeptno);
			RequestDispatcher dp = request.getRequestDispatcher("Employee.jsp");		
			dp.forward(request, response);
		}
		else
		{
			RequestDispatcher dp = request.getRequestDispatcher("null.html");		
			dp.forward(request, response);		
		}
	}

}
