package hospital_management.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hospital_management.entity.Doctor;
import hospital_management.exception.HospitalCustomException;
import hospital_management.repository.DoctorRepository;
import hospital_management.request.DoctorRequest;
import hospital_management.responce.DoctorResponce;

@Component
public class DoctorHelper {

	@Autowired
	DoctorRepository doctorRepository;

	public Doctor toEntity(DoctorRequest doctorRequest) {
		Doctor doctor = new Doctor();
		if(doctorRequest.getId() == null)
		{
			doctor = doctorRepository.findById(doctorRequest.getId())
					.orElseThrow(() -> new HospitalCustomException("doctors id not found"));
		}
		
		doctor.setName(doctorRequest.getName());
		doctor.setAddress(doctorRequest.getAddress());

		return doctor;
	}

	public DoctorResponce toDto(Doctor doctor) {
		DoctorResponce doctorResponce = new DoctorResponce();

		doctorResponce.setId(doctor.getId());
		doctorResponce.setName(doctor.getName());
		doctorResponce.setAddress(doctor.getAddress());
		return doctorResponce;
	}
}
