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
import com.jsp.model.EmployeeJ;
@WebServlet("/registerNone")
public class AddNewEmployee extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		String Ename = request.getParameter("uname");
		String tempsal = request.getParameter("usal");
		double Esal = Double.parseDouble(tempsal);
		String tempdept = request.getParameter("udept");
		int Edeptno = Integer.parseInt(tempdept);
		EmployeeJ emp = new EmployeeJ();
		emp.setEmpName(Ename);
		emp.setEmpSalary(Esal);
		emp.setEmpDeptNo(Edeptno);
		EmployeeDao dao = new EmployeeDaoImpl();
		int employee = dao.addEmployee(emp);
		if(employee!=0)
		{
			RequestDispatcher dp = request.getRequestDispatcher("index.jsp");		
			dp.include(request, response);
			writer.println("<h3>New Employee Added click above to check</h3>");
		}
		else {
			RequestDispatcher dp = request.getRequestDispatcher("EmployeeRegistration.html");		
			dp.forward(request, response);
		}
		
	}
	
}
