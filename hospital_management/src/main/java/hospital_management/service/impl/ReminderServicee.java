package hospital_management.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital_management.entity.Appointment;
import hospital_management.entity.Patient;
import hospital_management.exception.HospitalCustomException;
import hospital_management.repository.AppointmentRepository;
import hospital_management.repository.PatientRepository;

@Service
public class ReminderServicee {
	@Autowired
	EmailService emailService;
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	AppointmentRepository appointmentRepository;

	
	public void sendEmailReminderForAppointment(Integer appointmentId)
	{
		Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentId);
		
		if (appointmentOptional.isPresent()) {
            Appointment appointment = appointmentOptional.get();
            sendEmailReminder(appointment.getPatient());
            }
            else {
                throw new HospitalCustomException("Appointment with ID " + appointmentId + " not found.");
            }
	}
	
//		private boolean isEmailReminderNeeded(Appointment appointment) 
//		{
//			LocalDate now = LocalDate.now();
//			LocalDate appointmentDate = appointment.getAppointmentDate();
//			
//			Duration timeUntilAppointment  = Duration.between(now, appointmentDate);
//			 return timeUntilAppointment.toHours() <= 64; 
//		}
		 private void sendEmailReminder(Patient patient) 
		 {
			 String recipientEmail  = patient.getEmail();
			 String subject = "Appointment Reminder";
			 
			 
			 String message = "This is a reminder for your upcoming appointment.";
			 emailService.sendAppointmentReminder(recipientEmail, subject, message);
			 
		 }
		
		
//	public void sendEmailReminderToPatient(Integer id) {
//		Optional<Patient> optional = patientRepository.findById(id);
//
//		if (optional.isPresent()) {
//			Patient patient = optional.get();
//
//			if (isEmailReminderNeeded(patient)) {
//				sendEmailReminder(patient);
//			} else {
//				System.err.println("Patient with ID " + id + " not found");
//
//				throw new HospitalCustomException("Patient with ID " + id + " not found");
//			}
//		}
//	}
//		private boolean isEmailReminderNeeded(Patient patient)
//		{
//			LocalDate now = LocalDate.now();
//			LocalDate appointmentDate = patient.getAppointment().getAppointmentDate();
//			Duration timeUntilAppointment  = Duration.between(now, appointmentDate);
//			
//			  //long emailReminderThresholdHours = 24;
//			
//			  return timeUntilAppointment.compareTo(reminderThreshold) <= 0;
//		}
//		private void sendEmailReminder(Patient patient) 
//		{
//			String emailSubject = "Appointment Reminder"; 
//			
//			String emailMessage = "Dear " + patient.getName() + ",\n\n" +
//                    "This is a reminder for your appointment.\n" +
//                    "Please remember to attend Appointment .\n\n" +
//                    "Best regards,\n" +
//                    "Your Clinic";
//			emailService.sendAppointmentReminder(patient.getEmail(),emailSubject, emailMessage);
//			
//		}
}
