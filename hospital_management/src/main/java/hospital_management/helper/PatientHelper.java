package hospital_management.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hospital_management.entity.Appointment;
import hospital_management.entity.Patient;
import hospital_management.exception.HospitalCustomException;
import hospital_management.repository.AppointmentRepository;
import hospital_management.repository.PatientRepository;
import hospital_management.request.PatientRequest;
import hospital_management.responce.PatientResponce;

@Component
public class PatientHelper {

	@Autowired
	PatientRepository patientRepository;
	@Autowired
	AppointmentRepository appointmentRepository;
	
	public Patient toEntity(PatientRequest patientRequest) {
		Patient patient = new Patient();
		if (patientRequest.getId() != null) {
			patient = patientRepository.findById(patientRequest.getId())
					.orElseThrow(() -> new HospitalCustomException("patient id not found"));
					
		}
		
		patient.setName(patientRequest.getName());
		patient.setAge(patientRequest.getAge());
		patient.setAddress(patientRequest.getAddress());
		patient.setEmail(patientRequest.getEmail());
		patient.setPhoneNumber(patientRequest.getPhoneNumber());
	
		Appointment appointment = appointmentRepository.findById(patientRequest.getAppointmentId()).orElseThrow(() -> new HospitalCustomException("appointment id not found"));
		
		patient.setAppointment(appointment);
		return patient;
	}

	public PatientResponce toDto(Patient patient)
	{
		PatientResponce patientResponce= new PatientResponce();
		patientResponce.setId(patient.getId());
		patientResponce.setName(patient.getName());
		patientResponce.setAge(patient.getAge());
		patientResponce.setAddress(patient.getAddress());
		//patientResponce.setAddress(patient.getAddress());
		patientResponce.setEmail(patient.getEmail());
		patientResponce.setPhoneNumber(patient.getPhoneNumber());
		
		patientResponce.setAppointmentId(patient.getAppointment().getId());
		patientResponce.setAppointmentDate(patient.getAppointment().getAppointmentDate());
		patientResponce.setStatus(patient.getAppointment().getStatus());

		return patientResponce;
	}
}
