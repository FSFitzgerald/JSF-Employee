package com.hcmus.backing;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.hcmus.bo.EmployeesBO;
import com.hcmus.model.Employee;

@ManagedBean(name="backingEditEmployee", eager = true)
@SessionScoped
public class BackingEditEmployee {
	private Employee employee;
	
	@ManagedProperty(value = "#{employeesBO}")
	EmployeesBO employeesBO;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeesBO getEmployeesBO() {
		return employeesBO;
	}

	public void setEmployeesBO(EmployeesBO employeesBO) {
		this.employeesBO = employeesBO;
	}
	
	public String updateEmployee() {
		employeesBO.updateEmployee(employee);
		return "employees";
	}
}
