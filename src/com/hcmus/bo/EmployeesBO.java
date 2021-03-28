package com.hcmus.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.hcmus.model.Employee;
import com.hcmus.util.DBConnectionUtil;

@ManagedBean(name="employeesBO", eager = true)
@SessionScoped
public class EmployeesBO {
	public List<Employee> findAllEmployees(){
		String sql = "select * from employees";
		List<Employee> list = new ArrayList<>();
		try {
			Connection con = DBConnectionUtil.openConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Employee empl = new Employee();
				empl.setId(rs.getInt(1));
				empl.setFirstName(rs.getString(2));
				empl.setLastName(rs.getString(3));
				empl.setCompany(rs.getString(4));
				empl.setEmplNumber(rs.getString(5));
				empl.setSalary(rs.getDouble(6));
				list.add(empl);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void insertEmployee(Employee empl) {
		String sql = "insert into employees(first_name, last_name, company, empl_number, salary) values(?, ?, ?, ?, ?)";
		try {
			Connection con = DBConnectionUtil.openConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, empl.getFirstName());
			ps.setString(2, empl.getLastName());
			ps.setString(3, empl.getCompany());
			ps.setString(4, empl.getEmplNumber());
			ps.setDouble(5, empl.getSalary());
			
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateEmployee(Employee empl) {
		String sql = "update employees set first_name = ?, last_name = ?, company = ?, empl_number = ?, salary = ? where id = ?";
		try {
			Connection con = DBConnectionUtil.openConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, empl.getFirstName());
			ps.setString(2, empl.getLastName());
			ps.setString(3, empl.getCompany());
			ps.setString(4, empl.getEmplNumber());
			ps.setDouble(5, empl.getSalary());
			ps.setInt(6, empl.getId());
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteEmployee(int id) {
		String sql = "delete from employees where id = ?";
		try {
			Connection con = DBConnectionUtil.openConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
