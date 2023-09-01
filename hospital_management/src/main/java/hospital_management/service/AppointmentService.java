package hospital_management.service;

import java.time.LocalDate;
import java.util.List;

import hospital_management.entity.Doctor;
import hospital_management.request.AppointmentRequest;
import hospital_management.responce.AppointmentResponce;

public interface AppointmentService {
//AppointmentResponce bookAppointment (AppointmentRequest appointmentRequest);

	boolean isDoctorAvailable(Doctor doctor, LocalDate appointmentDate);

	String  bookAppointment (AppointmentRequest appointmentRequest);
	
	List<AppointmentResponce> getAll();
	
}
