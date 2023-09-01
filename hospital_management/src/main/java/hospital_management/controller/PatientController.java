package hospital_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hospital_management.repository.PatientRepository;
import hospital_management.request.PatientRequest;
import hospital_management.responce.PatientResponce;
import hospital_management.service.impl.PatientServiceImpl;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

	@Autowired
	PatientRepository patientRepository;
	@Autowired
	PatientServiceImpl patientServiceImpl;

	@PostMapping("/create")
	public ResponseEntity<PatientResponce> createPatient(@RequestBody PatientRequest patientRequest) {
		return new ResponseEntity<PatientResponce>(patientServiceImpl.createPatient(patientRequest),
				HttpStatus.CREATED);
	}

	@GetMapping("/getAllPatients")
	public List<PatientResponce> getAllPatients() {
		return patientServiceImpl.getAllPatients();
	}
	@GetMapping("/byId/{id}")
	public ResponseEntity<PatientResponce> findById(Integer id)
	{
		return new ResponseEntity<PatientResponce>(patientServiceImpl.findById(id), HttpStatus.OK);
	}
}
