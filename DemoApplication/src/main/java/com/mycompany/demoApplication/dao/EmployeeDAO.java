package com.mycompany.demoApplication.dao;

import java.util.List;

import com.mycompany.demoApplication.model.Employee;

public interface EmployeeDAO {

	public void addEmployee(Employee p);

	public void updateEmployee(Employee p);

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(int id);

	public void deleteEmployee(int id);
}
