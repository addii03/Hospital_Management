package hospital_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital_management.entity.Doctor;
import hospital_management.exception.HospitalCustomException;
import hospital_management.helper.DoctorHelper;
import hospital_management.repository.DoctorRepository;
import hospital_management.request.DoctorRequest;
import hospital_management.responce.DoctorResponce;
import hospital_management.service.DoctorService;
@Service
public class DoctorServiceImpl implements DoctorService{

	
	@Autowired 
	DoctorHelper doctorHelper;
	@Autowired
	DoctorRepository doctorRepository;
	@Override
	public DoctorResponce createDoctor(DoctorRequest doctorRequest) {
		Doctor doctor = doctorHelper.toEntity(doctorRequest);
		doctorRepository.save(doctor);	
		return doctorHelper.toDto(doctor);
	}
	@Override
	public DoctorResponce findById(Integer id) {
		Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new HospitalCustomException("doctors id not found"));
		return doctorHelper.toDto(doctor);
	}
	
}
