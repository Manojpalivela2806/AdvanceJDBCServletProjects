<%@page import="com.jsp.model.EmployeeJ"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
EmployeeJ emp =(EmployeeJ)session.getAttribute("empldetails");
%>
	<center>
	<form action="upempdet" method=""> 
	<label>EmployeeName</label>
	<input value="<%=emp.getEmpName()%>" name="upname">
	<br>
	<br>
	<label>EmployeeSalary</label>
	<input value="<%=emp.getEmpSalary()%>" name="upsal">
	<br>
	<br>
	<label>EmployeeDeptNo</label>
	<input value="<%=emp.getEmpDeptNo()%>" name="updeptno">
	<br>
	<br>
	<input type="submit">
	<input value="<%=emp.getEmpId()%>" hidden="true" name="uid">
	</form>
	</center>
</body>
</html>