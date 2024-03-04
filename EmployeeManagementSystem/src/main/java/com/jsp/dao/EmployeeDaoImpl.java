package com.jsp.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import com.jsp.model.EmployeeJ;

public class EmployeeDaoImpl implements EmployeeDao{

	String url="jdbc:mysql://localhost:3306/webproject?user=root&password=12345";
	String query="select * from employeej";
	String query1="select * from employeej where empSalary=? or empDeptNo=?";
	String update = "UPDATE employeej set empName=?,empSalary=?, empDeptNo=? WHERE empId=?";
	String selectId="select * from employeej where empId=?";
	String Delete = "delete from employeej where empId=?";
	String Insert ="insert into employeej (empName, empSalary, empDeptNo) values (?,?,?)";
	List<EmployeeJ> employee1 = new ArrayList<>();
	@Override
	public List<EmployeeJ> getAllEmployees() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			Statement statement = connection.createStatement();
			ResultSet eQ = statement.executeQuery(query);
			
			if(eQ.isBeforeFirst())
			{
				while(eQ.next())
				{
					 EmployeeJ emp = new EmployeeJ();
					 emp.setEmpId(eQ.getInt("empId"));
					 emp.setEmpName(eQ.getString("empName"));
					 emp.setEmpSalary(eQ.getDouble("empSalary"));
					 emp.setEmpDeptNo(eQ.getInt("empDeptNo"));
					 employee1.add(emp);
				}
				return employee1;
			}
			else {
				return null;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<EmployeeJ> getAllEmployeesByparamater(double i) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			int x=(int)i;
			PreparedStatement ps = connection.prepareStatement(query1);
			ps.setDouble(1, i);
			ps.setInt(2, x);
			ResultSet eQ = ps.executeQuery();
			if(eQ.isBeforeFirst())
			{
				while(eQ.next())
				{
					 EmployeeJ emp = new EmployeeJ();
					 emp.setEmpId(eQ.getInt("empId"));
					 emp.setEmpName(eQ.getString("empName"));
					 emp.setEmpSalary(eQ.getDouble("empSalary"));
					 emp.setEmpDeptNo(eQ.getInt("empDeptNo"));
					 employee1.add(emp);
				}
				return employee1;
			}
			else {
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
//	@Override
//	public EmployeeJ updateEmployee(int id) {
//		try {
//			Connection connection = DriverManager.getConnection(url);
//			EmployeeJ empl = new EmployeeJ();
//			PreparedStatement ps = connection.prepareStatement(selectId);
//			ps.setInt(1, id);
//			ResultSet rset = ps.executeQuery();
//			if(rset.next())
//			{
//				PreparedStatement ps1 = connection.prepareStatement(update);
//				ps1.setString(1,rset.getString("empName"));
//				ps1.setDouble(2, rset.getDouble("empSalary"));
//				ps1.setInt(3, rset.getInt("empDeptNo"));
//				ps1.setInt(4, id);
//				int ex1 = ps1.executeUpdate();
//				if (ex1!=0) {
//					System.out.println("updated");
//				} else {
//					System.out.println("not updated");
//				}
//			}
//			else
//			{
////				return null;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//		return null;
//	}
	@Override
	public EmployeeJ getEmployeeById(int id) {
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(selectId);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				EmployeeJ emplo = new EmployeeJ();
					emplo.setEmpId(rs.getInt("empId"));
					emplo.setEmpName(rs.getString("empName"));
					emplo.setEmpSalary(rs.getDouble("empSalary"));
					emplo.setEmpDeptNo(rs.getInt("empDeptNo"));
					return emplo;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int updateEmployeeDetails(EmployeeJ employee) {
		
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement st = connection.prepareStatement(update);
			st.setString(1, employee.getEmpName());
			st.setDouble(2, employee.getEmpSalary());
			st.setInt(3, employee.getEmpDeptNo());
			st.setInt(4,employee.getEmpId());
			int result = st.executeUpdate();
			if (result!=0) {
				return result;
			} else {
				return result;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return 0;	
	}
//	@Override
//	public int deleteEmployee(int id) {
//		try {
//			Connection connection = DriverManager.getConnection(url);
//			PreparedStatement st = connection.prepareStatement(Delete);
//			st.setInt(1, id);
//			int eup = st.executeUpdate();
//			if(eup!=0)
//			{
//				return eup;
//			}
//			else {
//				return 0;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return 0;
//	}
	@Override
	public int deleteEmployee(int id) {
		try {
			FileInputStream f = new FileInputStream("C:\\Users\\Manoj Palivela\\eclipse-workspace\\EmployeeManagementSystem\\src\\main\\java\\com\\jsp\\file\\Application.properties");
			Properties p = new Properties();
			p.load(f);
			String property = p.getProperty("url1");
			String username = p.getProperty("user");
			String password = p.getProperty("password");
			
			Connection connection = DriverManager.getConnection(property,username,password);
			PreparedStatement st = connection.prepareStatement(Delete);
			st.setInt(1, id);
			return st.executeUpdate();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	@Override
	public int addEmployee(EmployeeJ employee) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement st = connection.prepareStatement(Insert);
			st.setString(1, employee.getEmpName());
			st.setDouble(2,employee.getEmpSalary());
			st.setInt(3, employee.getEmpDeptNo());
			return st.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	

}
//192.166.000.103  ip address