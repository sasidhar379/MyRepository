package com.mycompany.demoApplication.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.demoApplication.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addEmployee(Employee employee) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee> personsList = session.createQuery("from Employee").list();
		return personsList;
	}

	@Override
	public Employee getEmployeeById(int employee_id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.load(Employee.class, new Integer(employee_id));
		return employee;
	}

	@Override
	public void deleteEmployee(int employee_id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee empoyee = (Employee) session.load(Employee.class, new Integer(employee_id));
		if (null != empoyee) {
			session.delete(empoyee);
		}
	}

}
