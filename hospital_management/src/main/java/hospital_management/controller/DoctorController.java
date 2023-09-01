
package hospital_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hospital_management.repository.DoctorRepository;
import hospital_management.request.DoctorRequest;
import hospital_management.responce.DoctorResponce;
import hospital_management.service.impl.DoctorServiceImpl;

@RestController

@RequestMapping("/api/doctor")
public class DoctorController {

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	DoctorServiceImpl doctorServiceImpl;

	@PostMapping("/create")
	public ResponseEntity<DoctorResponce> createDoctor(@RequestBody DoctorRequest doctorRequest) {
		return new ResponseEntity<DoctorResponce>(doctorServiceImpl.createDoctor(doctorRequest), HttpStatus.CREATED);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<DoctorResponce> findById(Integer id)
	{
		return new ResponseEntity<DoctorResponce>(doctorServiceImpl.findById(id), HttpStatus.OK);
	}
}
