package hospital_management.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hospital_management.entity.Appointment;
import hospital_management.entity.Doctor;
import hospital_management.entity.Patient;
import hospital_management.exception.HospitalCustomException;
import hospital_management.repository.AppointmentRepository;
import hospital_management.repository.DoctorRepository;
import hospital_management.repository.PatientRepository;
import hospital_management.request.AppointmentRequest;
import hospital_management.responce.AppointmentResponce;

@Component
public class AppointmentHelper {
	@Autowired
	AppointmentRepository appointmentRepository;

	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	PatientRepository patientRepository;

	public Appointment toEntity(AppointmentRequest appointmentRequest) {
		Appointment appointment = new Appointment();
		
//		appointment = appointmentRepository.findById(appointmentRequest.getId())
//				.orElseThrow(() -> new HospitalCustomException("appointment id not found"));
//		if (appointment == null) {
//			appointment = 
//		}

		if (appointmentRequest.getId() == null) {
			appointment = appointmentRepository.findById(appointmentRequest.getId())
					.orElseThrow(() -> new HospitalCustomException("appointment id not found"));
		}
		appointment.setAppointmentDate(appointmentRequest.getAppointmentDate());
		appointment.setReason(appointmentRequest.getReason());
		appointment.setStatus(appointmentRequest.getStatus());

		Doctor doctor = doctorRepository.findById(appointmentRequest.getDoctorId())
				.orElseThrow(() -> new HospitalCustomException("doctors id not found"));
		appointment.setDoctor(doctor);
		Patient patient = patientRepository.findById(appointmentRequest.getPatientId())
				.orElseThrow(() -> new HospitalCustomException("patient id not found"));
		appointment.setPatient(patient);
		return appointment;

	}

	public AppointmentResponce toDto(Appointment appointment) {
		AppointmentResponce appointmentResponce = new AppointmentResponce();

		appointmentResponce.setId(appointment.getId());
		appointmentResponce.setAppointmentDate(appointment.getAppointmentDate());
		appointmentResponce.setReason(appointment.getReason());
		appointmentResponce.setStatus(appointment.getStatus());

		appointmentResponce.setPatientId(appointment.getPatient().getId());
		appointmentResponce.setPatientName(appointment.getPatient().getName());
		appointmentResponce.setPatientAddress(appointment.getPatient().getAddress());
		appointmentResponce.setPatientAge(appointment.getPatient().getAge());
		appointmentResponce.setPhoneNumber(appointment.getPatient().getPhoneNumber());
		appointmentResponce.setPatientEmail(appointment.getPatient().getEmail());
		
		appointmentResponce.setDoctorId(appointment.getDoctor().getId());
		appointmentResponce.setDoctorName(appointment.getDoctor().getName());
		appointmentResponce.setDoctorAddress(appointment.getDoctor().getAddress());
		return appointmentResponce;
	}
}
