package com.hcmus.backing;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.hcmus.bo.EmployeesBO;
import com.hcmus.model.Employee;

@ManagedBean(name = "backingAddEmployee")
@ViewScoped
public class BackingAddEmployee {
	
	private Employee employee = new Employee();
	
	@ManagedProperty(value = "#{employeesBO}")
	EmployeesBO employeesBO;

	public EmployeesBO getEmployeesBO() {
		return employeesBO;
	}

	public void setEmployeesBO(EmployeesBO employeesBO) {
		this.employeesBO = employeesBO;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String saveEmployee() {
		employeesBO.insertEmployee(employee);
		return "employees";
	}
}
