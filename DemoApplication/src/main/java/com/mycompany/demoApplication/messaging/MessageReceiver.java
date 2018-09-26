package com.mycompany.demoApplication.messaging;

import javax.jms.JMSException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.mycompany.demoApplication.dao.EmployeeDAO;
import com.mycompany.demoApplication.model.Employee;

@Component
public class MessageReceiver {

	public final static Logger log = Logger.getLogger(MessageReceiver.class);

	private static final String EMPLOYEE_RESPONSE_QUEUE = "employee-response-queue";

	@Autowired
	EmployeeDAO employeeDAO;

	@JmsListener(destination = EMPLOYEE_RESPONSE_QUEUE)
	public void receiveMessage(final Message<Employee> message) throws JMSException {
		Employee response = (Employee) message.getPayload();
		employeeDAO.addEmployee(response);
	}
}