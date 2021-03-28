package com.hcmus.backing;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.hcmus.bo.EmployeesBO;
import com.hcmus.model.Employee;

@ManagedBean(name="backingEmployees")
@SessionScoped
public class BackingEmployees {
	
	@ManagedProperty(value = "#{employeesBO}")
	EmployeesBO employeesBO;
	
	@ManagedProperty(value = "#{backingEditEmployee}")
	BackingEditEmployee backingEditEmployee;
	
	
	public EmployeesBO getEmployeesBO() {
		return employeesBO;
	}

	public void setEmployeesBO(EmployeesBO employeesBO) {
		this.employeesBO = employeesBO;
	}

	public BackingEditEmployee getBackingEditEmployee() {
		return backingEditEmployee;
	}

	public void setBackingEditEmployee(BackingEditEmployee backingEditEmployee) {
		this.backingEditEmployee = backingEditEmployee;
	}

	public List<Employee> findAllEmployees(){
		return employeesBO.findAllEmployees();
	}
	
	public String edit(Employee empl) {
		backingEditEmployee.setEmployee(empl);
		return "update-employee";
	}
	
	public void delete(int id) {
		employeesBO.deleteEmployee(id);
	}
}
