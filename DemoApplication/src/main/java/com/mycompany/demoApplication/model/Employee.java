package com.mycompany.demoApplication.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employee_id;
	private String employee_firstName;
	private String employee_lastName;
	private Date employee_dob;
	private String employee_address;
	private String employee_phone;
	private String employee_email;

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_firstName() {
		return employee_firstName;
	}

	public void setEmployee_firstName(String employee_firstName) {
		this.employee_firstName = employee_firstName;
	}

	public String getEmployee_lastName() {
		return employee_lastName;
	}

	public void setEmployee_lastName(String employee_lastName) {
		this.employee_lastName = employee_lastName;
	}

	public Date getEmployee_dob() {
		return employee_dob;
	}

	public String getEmployee_dob_Formatted() {
		return new SimpleDateFormat("MM/dd/yyyy").format(employee_dob);
	}

	public void setEmployee_dob(Date employee_dob) {
		this.employee_dob = employee_dob;
	}

	public String getEmployee_address() {
		return employee_address;
	}

	public void setEmployee_address(String employee_address) {
		this.employee_address = employee_address;
	}

	public String getEmployee_phone() {
		return employee_phone;
	}

	public void setEmployee_phone(String employee_phone) {
		this.employee_phone = employee_phone;
	}

	public String getEmployee_email() {
		return employee_email;
	}

	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}

}
