package com.cg.springmvcone.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.springmvcone.dto.Employee;

@Repository("employeedao")
public class DaoEmployeeImpl  implements IDaoEmployee{

	@PersistenceContext
	EntityManager entitymanager;
	
	@Override
	public int addEmployeeData(Employee emp) {
		
		System.out.println("Hi before persist");
		entitymanager.persist(emp);
		System.out.println("Hi after persist");
		entitymanager.flush();
		System.out.println("Hi after flush");
		return emp.getEmpId();
	}

	@Override
	public List<Employee> showAllEmployee() {
		Query queryOne = entitymanager.createQuery("FROM Employee");
		List<Employee> myList= queryOne.getResultList();
		
		return myList;
	}

	@Override
	public void deleteEmployee(int empId) {
		Query queryTwo = entitymanager.createQuery("DELETE FROM Employee WHERE empId=:eid");
		queryTwo.setParameter("eid", empId);
		queryTwo.executeUpdate();
		
	}

	@Override
	public void updateEmployee(Employee emp) {
		Query queryThree = entitymanager.createQuery("UPDATE FROM Employee SET emp_name=:empName emp_deg=:empDeg emp_sal=:empSal "
				+ "emp_gen=:empGen  WHERE empId=:eid");
		queryThree.setParameter("empName", emp.getEmpName());
		queryThree.setParameter("empDeg", emp.getEmpDesignation());
		queryThree.setParameter("empSal", emp.getEmpSalary());
		queryThree.setParameter("empGen", emp.getEmpGender());
	}

	@Override
	public Employee searchEmployee(int id) {
		Employee emp = new Employee();
		Query queryFour = entitymanager.createQuery("FROM Employee WHERE empId=:eid");
		queryFour.setParameter("eid",id);
		//queryFour.executeUpdate();
		emp = (Employee) queryFour.getSingleResult();
		System.out.println(id);
		return emp;
	}

}
