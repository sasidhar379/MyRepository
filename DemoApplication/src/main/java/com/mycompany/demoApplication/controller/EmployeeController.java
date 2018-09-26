package com.mycompany.demoApplication.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.demoApplication.exceptions.ServiceException;
import com.mycompany.demoApplication.model.Employee;
import com.mycompany.demoApplication.service.EmployeeService;

@Controller
public class EmployeeController {

	public final static Logger log = Logger.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listPersons(Model model) {
		List<Employee> allEmployees = this.employeeService.getAllEmployees();
		if (allEmployees != null && !allEmployees.isEmpty()) {
			model.addAttribute("allEmployees", allEmployees);
		} else {
			model.addAttribute("error", "No Employees to display");
		}
		return "employee";
	}

	@RequestMapping(value = "/employee/addEmployee", method = RequestMethod.POST)
	public String addEmployee(HttpServletRequest req, Model model) {
		try {
			Employee emp = new Employee();
			emp.setEmployee_firstName(req.getParameter("fName"));
			emp.setEmployee_lastName(req.getParameter("lName"));
			emp.setEmployee_dob(new SimpleDateFormat("MM/dd/yyyy").parse(req.getParameter("dob")));
			emp.setEmployee_address(req.getParameter("address"));
			emp.setEmployee_phone(req.getParameter("phone"));
			emp.setEmployee_email(req.getParameter("email"));
			this.employeeService.addEmployee(emp);
		} catch (ParseException ex) {
			log.info(ex);
			model.addAttribute("error", "Invalid Date of Birth");
		} catch (ServiceException ex) {
			log.info(ex);
			model.addAttribute("error", "Unable to save Employee, plese check the date you've entered");
		} catch (Exception ex) {
			log.info(ex);
			model.addAttribute("error", "Unable to save Employee, plese try again later");
		}
		return "redirect:/";
	}

	@RequestMapping("/employee/deleteEmployee")
	public String deleteEmployee(HttpServletRequest req, Model model) {
		try {
			this.employeeService.deleteEmployee(Integer.valueOf(req.getParameter("id")));
		} catch (Exception ex) {
			log.info(ex);
			model.addAttribute("error", "unable to delete the Employee");
		}
		return "redirect:/";
	}

	@SuppressWarnings("deprecation")
	@RequestMapping("/employee/updateEmployee")
	public String editPerson(HttpServletRequest req, Model model) {
		try {
			Employee emp = new Employee();
			emp.setEmployee_id(Integer.valueOf(req.getParameter("eId")));
			emp.setEmployee_firstName(req.getParameter("fName"));
			emp.setEmployee_lastName(req.getParameter("lName"));
			emp.setEmployee_dob(new Date(req.getParameter("dob")));
			emp.setEmployee_address(req.getParameter("address"));
			emp.setEmployee_phone(req.getParameter("phone"));
			emp.setEmployee_email(req.getParameter("email"));
			this.employeeService.updateEmployee(emp);
		} catch (ServiceException ex) {
			log.info(ex);
			model.addAttribute("error", "Unable to update Employee, plese check the date you've entered");
		} catch (Exception ex) {
			log.info(ex);
			model.addAttribute("error", "Unable to update Employee, plese try again later");
		}
		return "redirect:/";
	}

}
