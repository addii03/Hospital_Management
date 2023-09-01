package hospital_management.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital_management.entity.Patient;
import hospital_management.exception.HospitalCustomException;
import hospital_management.helper.PatientHelper;
import hospital_management.repository.PatientRepository;
import hospital_management.request.PatientRequest;
import hospital_management.responce.PatientResponce;
import hospital_management.service.PatientService;
@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	PatientRepository patientRepository;
	@Autowired
	PatientHelper patientHelper;
	@Override
	public PatientResponce createPatient(PatientRequest patientRequest) {
		Patient patient = patientHelper.toEntity(patientRequest);
		patientRepository.save(patient);	
		return patientHelper.toDto(patient);
	}
	@Override
	public List<PatientResponce> getAllPatients() {
	List<Patient> list = patientRepository.findAll();
	
		return list.stream().map(patientHelper::toDto).collect(Collectors.toList());
	}
	@Override
	public PatientResponce findById(Integer id) {
	 Patient patient = patientRepository.findById(id).orElseThrow(() -> new HospitalCustomException("patient id not found"));
		return patientHelper.toDto(patient);
	}
	
}
