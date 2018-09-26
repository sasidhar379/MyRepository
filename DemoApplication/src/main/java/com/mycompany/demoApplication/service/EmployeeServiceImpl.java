package com.mycompany.demoApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.demoApplication.dao.EmployeeDAO;
import com.mycompany.demoApplication.exceptions.ServiceException;
import com.mycompany.demoApplication.messaging.MessageSender;
import com.mycompany.demoApplication.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	 @Autowired
	 MessageSender messageSender;

	@Override
	@Transactional
	public void addEmployee(Employee employee) throws ServiceException {
		if (employee != null) {
			this.employeeDAO.addEmployee(employee);
			messageSender.sendMessage(employee);
		}
		throw new ServiceException("Invalid Employee");
	}

	@Override
	@Transactional
	public void updateEmployee(Employee employee) throws ServiceException {
		if (employee != null && employee.getEmployee_id() != 0) {
			this.employeeDAO.updateEmployee(employee);
		}
		throw new ServiceException("Cannot Upadate the given Employee, Employee or Employee Id is empty");
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		return this.employeeDAO.getAllEmployees();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int employee_id) {
		if (employee_id != 0) {
			return this.employeeDAO.getEmployeeById(employee_id);
		}
		return null;
	}

	@Override
	@Transactional
	public void deleteEmployee(int employee_id) throws ServiceException {
		if (employee_id != 0) {
			this.employeeDAO.deleteEmployee(employee_id);
		}
		throw new ServiceException("Cannot delete the given employee, the provided EmployeeId is invalid");
	}

}
