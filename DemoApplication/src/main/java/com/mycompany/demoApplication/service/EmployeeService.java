package com.mycompany.demoApplication.service;

import java.util.List;

import com.mycompany.demoApplication.exceptions.ServiceException;
import com.mycompany.demoApplication.model.Employee;

public interface EmployeeService {

	public void addEmployee(Employee p) throws ServiceException;

	public void updateEmployee(Employee p) throws ServiceException;

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(int id);

	public void deleteEmployee(int id) throws ServiceException;

}
