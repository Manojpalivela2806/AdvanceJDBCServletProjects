package com.jsp.model;

public class EmployeeJ {

	
		
		private int empId;
		private String empName;
		private double empSalary;
		private int empDeptNo;
		
		public EmployeeJ(int empId, String empName, double empSalary, int empDeptNo) {
			this.empId = empId;
			this.empName = empName;
			this.empSalary = empSalary;
			this.empDeptNo = empDeptNo;
		}
		public EmployeeJ() {
			super();
			// TODO Auto-generated constructor stub
		}
		

		public int getEmpId() {
			return empId;
		}

		public void setEmpId(int empId) {
			this.empId = empId;
		}

		public String getEmpName() {
			return empName;
		}


		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public double getEmpSalary() {
			return empSalary;
		}

		public void setEmpSalary(double empSalary) {
			this.empSalary = empSalary;
		}

		public int getEmpDeptNo() {
			return empDeptNo;
		}

		public void setEmpDeptNo(int empDeptNo) {
			this.empDeptNo = empDeptNo;
		}
		@Override
		public String toString() {
			return "EmployeeJ [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empDeptNo="
					+ empDeptNo + "]";
		}
			
}

//223349137
//%><%= %><%
