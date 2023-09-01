package hospital_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hospital_management.exception.HospitalCustomException;
import hospital_management.repository.AppointmentRepository;
import hospital_management.service.impl.ReminderServicee;

@RestController
@RequestMapping("/api/reminder")
public class ReminderController {

	@Autowired
	ReminderServicee reminderService;

	@Autowired
	AppointmentRepository appointmentRepository;

//	@GetMapping("/send")
//	public String sendAppointmentReminders() {
//		reminderService.sendAppointmentReminders();
//		return "Appointment reminders sent successfully.";
//	}
	
//	@PostMapping("/send-email")
//	public ResponseEntity<String> sendEmailReminderToPatient(@RequestBody Map<String, Object> requestBody) {
//	    Long patientId = Long.parseLong(requestBody.get("patientId").toString());
//	    int reminderThresholdHours = Integer.parseInt(requestBody.get("reminderThreshold").toString());
//
//	    try {
//	    	reminderServicee.sendEmailReminderToPatient(patientId, Duration.ofHours(reminderThresholdHours));
//	        return ResponseEntity.ok("Email reminder sent successfully.");
//	    } catch (HospitalCustomException e) {
//	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found.");
//	    } catch (Exception e) {
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
//	    }
//	}

//	
//	@PostMapping("/reminder/{id}")
//	public String sendEmailReminderToPatient (Integer id,Duration reminderThreshold) 
//	{
//		 reminderServicee.sendEmailReminderToPatient(id, reminderThreshold);
//		 return "Email reminder sent successfully.";
//	}
	
	@PostMapping("/send-email")
    public ResponseEntity<String> sendEmailReminder(@RequestParam Integer appointmentId) {
        try {
            reminderService.sendEmailReminderForAppointment(appointmentId);
            return ResponseEntity.ok("Email reminder sent successfully.");
        } catch (HospitalCustomException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment not found.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }
}
