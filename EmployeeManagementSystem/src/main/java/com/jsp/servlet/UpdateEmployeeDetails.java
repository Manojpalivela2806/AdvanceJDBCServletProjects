package com.jsp.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.jsp.dao.EmployeeDao;
import com.jsp.dao.EmployeeDaoImpl;
import com.jsp.model.EmployeeJ;
@WebServlet("/upempdet")
public class UpdateEmployeeDetails extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("upname");
		String tempsal = request.getParameter("upsal");
		String tempdeptno = request.getParameter("updeptno");
		String tempid = request.getParameter("uid");
		Double sal=Double.parseDouble(tempsal);
		int deptno=Integer.parseInt(tempdeptno);
		int id=Integer.parseInt(tempid);
//		System.out.println(name+" "+sal+" "+deptno+" "+id);
		EmployeeJ employee = new EmployeeJ();
		employee.setEmpId(id);
		employee.setEmpName(name);
		employee.setEmpSalary(sal);
		employee.setEmpDeptNo(deptno);
		EmployeeDao dao = new EmployeeDaoImpl();
		int updateEmployeeDetails = dao.updateEmployeeDetails(employee);
		if(updateEmployeeDetails!=0)
		{
			RequestDispatcher rd = request.getRequestDispatcher("/allemp");
			rd.include(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("null.html");
			rd.include(request, response);
		}
		
	}

	

}
