package hospital_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hospital_management.repository.AppointmentRepository;
import hospital_management.request.AppointmentRequest;
import hospital_management.responce.AppointmentResponce;
import hospital_management.service.impl.AppointmentServiceImpl;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

	@Autowired
	AppointmentRepository appointmentRepository;
	@Autowired
	AppointmentServiceImpl appointmentServiceImpl;
	
//	@PostMapping("/bookAppointment")
//	public ResponseEntity<AppointmentResponce> bookAppointment(@RequestBody AppointmentRequest appointmentRequest)
//	{
//		return new ResponseEntity<AppointmentResponce>(appointmentServiceImpl.bookAppointment(appointmentRequest), HttpStatus.CREATED);
//	}
	
//	@PostMapping("/bookAppointment")
//	public ResponseEntity<String> bookAppointment(
//            @RequestParam Integer doctorId,
//            @RequestParam Integer patientId,
//            @RequestParam String appointmentDate,
//            @RequestParam String reason,
//            @RequestParam AppointmentStatus status
//			)
//	{
//		LocalDate appointmentDate2 = LocalDate.parse(appointmentDate);
//		
//			 String bookingResult = appointmentServiceImpl.bookAppointment(doctorId, patientId, appointmentDate2, reason, status);
//		if (bookingResult.equals("Appointment booked successfully"))	
//		{
//			return ResponseEntity.ok(bookingResult);
//		}
//		else {
//			return ResponseEntity.status(HttpStatus.CONFLICT).body(bookingResult);
//		}
//	}
//	 @PostMapping("/book")
//	    public ResponseEntity<String> bookAppointment(@RequestBody AppointmentRequest appointmentRequest) {
//	        try {
//	            appointmentServiceImpl.bookAppointment(appointmentRequest);
//	            return ResponseEntity.ok("Appointment booked successfully. Confirmation email sent.");
//	        } catch (HospitalCustomException e) {
//	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment not found.");
//	        } catch (Exception e) {
//	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
//	        }
	
	 @PostMapping("/book")
	 public String bookAppointment(@RequestBody AppointmentRequest appointmentRequest)
	 {
		 appointmentServiceImpl.bookAppointment(appointmentRequest);
		 return "Appointment booked successfully. Confirmation email sent.";
	 }
	@GetMapping("/getAllAppointments")
	public List<AppointmentResponce> getAll()
	{
		return appointmentServiceImpl.getAll();
	}
}
