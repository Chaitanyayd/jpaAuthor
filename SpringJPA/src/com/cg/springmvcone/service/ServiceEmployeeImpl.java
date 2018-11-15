package com.cg.springmvcone.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.springmvcone.dao.IDaoEmployee;
import com.cg.springmvcone.dto.Employee;

@Service("employeeservice")
@Transactional
public class ServiceEmployeeImpl implements IServiceEmployee {

	@Autowired
	IDaoEmployee employeedao;
	
	
	@Override
	public int addEmployeeData(Employee emp) {
		
		return employeedao.addEmployeeData(emp);
	}

	@Override
	public List<Employee> showAllEmployee() {
		
		return employeedao.showAllEmployee();
	}

	@Override
	public void deleteEmployee(int empId) {
		
		employeedao.deleteEmployee(empId);
	}

	@Override
	public void updateEmployee(Employee emp) {
		
		employeedao.updateEmployee(emp);
		
	}

	@Override
	public Employee searchEmployee(int id) {
		
		return employeedao.searchEmployee(id);
	}

}
