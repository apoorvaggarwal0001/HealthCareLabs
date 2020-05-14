package org.com.service;

import java.util.List;
import java.util.Optional;

import org.com.dao.AppointmentRepositories;
import org.com.dao.DiagnosticCentreRepositories;
import org.com.error.RecordNotFoundException;
import org.com.model.Appointment;
import org.com.model.DiagnosticCentre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepositories appointmentDao;
	
	@Autowired
	DiagnosticCentreRepositories diagnosticCentreDao;
	
	public List<Appointment> getAllAppointments(){
		return appointmentDao.findAll();
	}
	
	public ResponseEntity<?> searchAppointment(int appointmentid) {
		Optional<Appointment> findById=appointmentDao.findById(appointmentid);
		try {
			if(findById.isPresent()) {
				Appointment appointment=findById.get();
				return new ResponseEntity<Appointment>(appointment,HttpStatus.OK);
			}
			else
				throw new RecordNotFoundException("Record not found");
		}
		catch(RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<Appointment> saveAppointment(Appointment appointment) {
		Optional<Appointment> findById=appointmentDao.findById(appointment.getAppointmentId());
		try{
			if(!findById.isPresent()) {
				appointmentDao.save(appointment);
				return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
			}
			else
				throw new RecordNotFoundException("Record already present...");
		}
		catch(RecordNotFoundException e){
			return new ResponseEntity<Appointment>(appointment, HttpStatus.NOT_FOUND);
		}
	}
	
	public String removeAppointment(int appointmentid) {
		Optional<Appointment> findById=appointmentDao.findById(appointmentid);
		if(findById.isPresent()) {
			appointmentDao.deleteById(appointmentid);
			return "Appointment removed";
		}
		
		return "Appointment not present";
	}
	
	public ResponseEntity<Appointment> updateAppointment(Appointment appoint) {

        Optional<Appointment> findById = appointmentDao.findById(appoint.getAppointmentId());
        try {
            if (findById.isPresent()) {
            	appointmentDao.save(appoint);
                return new ResponseEntity<Appointment>(appoint, HttpStatus.OK);
            	} 
            else {
                throw new RecordNotFoundException("Appointment not present");
            }
        }
        catch (RecordNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
	public String getDiagnosticCentreName(Integer tid) {
		Optional<Appointment> findById=appointmentDao.findById(tid);
			Appointment app=new Appointment();
			app=findById.get();
			Optional<DiagnosticCentre> findById2=diagnosticCentreDao.findById(app.getDiagnosticCentreId());
			DiagnosticCentre dc=new DiagnosticCentre();
			dc=findById2.get();
			return dc.getCentreName();
	}
}
