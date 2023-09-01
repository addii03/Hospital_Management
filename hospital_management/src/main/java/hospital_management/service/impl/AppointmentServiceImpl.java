package hospital_management.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital_management.entity.Appointment;
import hospital_management.entity.Doctor;
import hospital_management.helper.AppointmentHelper;
import hospital_management.repository.AppointmentRepository;
import hospital_management.repository.DoctorRepository;
import hospital_management.repository.PatientRepository;
import hospital_management.request.AppointmentRequest;
import hospital_management.responce.AppointmentResponce;
import hospital_management.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	AppointmentHelper appointmentHelper;
	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	EmailService emailService;
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	AppointmentRepository appointmentRepository;
//	@Override
//	public AppointmentResponce bookAppointment(AppointmentRequest appointmentRequest) {
//		Appointment appointment = appointmentHelper.toEntity(appointmentRequest);
//		appointmentRepository.save(appointment);
//		return appointmentHelper.toDto(appointment);
//	}

	@Override
	public boolean isDoctorAvailable(Doctor doctor, LocalDate appointmentDate) {

		List<Appointment> appointments = appointmentRepository.findByDoctorAndAppointmentDate(doctor, appointmentDate);
		return appointments.isEmpty();
	}

	@Override
	public String bookAppointment(AppointmentRequest appointmentRequest) {

//		Doctor doctor = doctorRepository.findById(patientId)
//				.orElseThrow(() -> new HospitalCustomException("doctors id not found"));
//		Patient patient = patientRepository.findById(patientId)
//				.orElseThrow(() -> new HospitalCustomException("patients id not found"));
//
//		if (doctor == null || patient == null) {
//			return "Invalid doctor or patient ID";
//		}
//
//		if (!isDoctorAvailable(doctor, appointmentDate)) {
//			return "Doctor's slot is full at the selected time";
//		}
//		Appointment appointment = new Appointment();
//		appointment.setDoctor(doctor);
//		appointment.setPatient(patient);
//		appointment.setAppointmentDate(appointmentDate);
//		appointment.setReason(reason);
//		appointment.setStatus(status);
		
		Appointment appointment = appointmentHelper.toEntity(appointmentRequest);
		appointmentRepository.save(appointment);

		sendConfirmationEmail(appointment);

		return "Appointment booked successfully";
	}

	private void sendConfirmationEmail(Appointment appointment) {
		String recipientEmail = appointment.getPatient().getEmail();
		String subject = "Appointment Confirmation";
		String message = "Your appointment has been successfully booked for " + appointment.getAppointmentDate() + ".";
		emailService.sendEmail(recipientEmail, subject, message);
	}

	@Override
	public List<AppointmentResponce> getAll() {
		List<Appointment> list = appointmentRepository.findAll();

		return list.stream().map(appointmentHelper::toDto).collect(Collectors.toList());
	}
}
