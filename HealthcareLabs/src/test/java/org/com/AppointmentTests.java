package org.com;

import org.com.model.Admin;
import org.com.model.Appointment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class AppointmentTests	 {
	
	static Logger logger = LoggerFactory.getLogger(AppointmentTests.class);

	
	RestTemplate restTemplate;
	@BeforeEach
	public void setUp() {
		restTemplate = new RestTemplate();
	}
	
	@Test
	public void searchAppointment() {
		Appointment appointment = restTemplate.getForObject("http://localhost:9090/appoint/searchAppointment/2", Appointment.class);
		Assertions.assertNotNull(appointment);
		logger.info("Search Appointment Works!!");
	}
	
	@Test
	public void addAppointment() {
		Appointment appointment=new Appointment();
		appointment.setAppointmentId(156);
		appointment.setDiagnosticCentreId(123);
		appointment.setTestId(432);
		appointment.setDate1("12/12/12");
		appointment.setTime1("23:34");
		appointment.setTotalCost(3455);
		appointment.setApproved(true);
		ResponseEntity<Appointment> postForEntity = restTemplate.postForEntity("http://localhost:9090/appoint/addAppointment",appointment, Appointment.class);
		Assertions.assertNotNull(postForEntity);
		logger.info("Add Appointment Works!!");
	}
}