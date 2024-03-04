<%@page import="java.util.List"%>
<%@page import="com.jsp.dao.EmployeeDao"%>
<%@page import="com.jsp.model.EmployeeJ"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Employees Details</title>
<style>
th{
background-color:grey;
color:white;
}
#update{
color:bisque;
background-color:blue;
}
#delete{
background-color:red;
color:yellow;
}
#search{
background-color:purple;
color:yellow;
}
button{
position:absolute;
left:45%;
top:60%;
}
</style>
</head>
<body>
<center>
<form action="search" method="post">
<input type="text" placeholder="Enter the deptno" name="dept" >
<input id="search" type="submit" value="search">
</center>
</form>
<center>
<table border='1'>
<tr>
<th>EmployeeId</th>
<th>EmployeeName</th>
<th>EmployeeSalary</th>
<th>EmployeeDeptNo</th>
</tr>

<% 

List<EmployeeJ> emp=(List<EmployeeJ>)session.getAttribute("listofemployees");


for(EmployeeJ employee:emp)
	{
%>
	<tr><td><%=employee.getEmpId() %></td>
	<td><%=employee.getEmpName() %></td>
	<td><%=employee.getEmpSalary() %></td>
	<td><%=employee.getEmpDeptNo() %></td>
	<td>
	<form action="upbyid" method="post">
	<input value=<%=employee.getEmpId()%> hidden="true" name="upd">
	<input id="update" type="submit" value="Update">
	</form>
	</td>
	<td>
	<form action="delbyId" method="post">
	<input value=<%=employee.getEmpId()%> hidden="true" name="del">
	<input id="delete" type="submit" value="Delete"></td>
	</form>
	</tr>	
<%}
%>
<button><a href="EmployeeRegistration.html">addEmployee</a></button>


</table>
</center>
</body>
</html>



