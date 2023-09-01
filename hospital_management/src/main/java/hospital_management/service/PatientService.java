package hospital_management.service;

import java.util.List;

import hospital_management.request.PatientRequest;
import hospital_management.responce.PatientResponce;

public interface PatientService {

	PatientResponce createPatient (PatientRequest patientRequest);
	List<PatientResponce> getAllPatients ();
	PatientResponce findById(Integer id);
}
