package hospital_management.service;

import hospital_management.request.DoctorRequest;
import hospital_management.responce.DoctorResponce;

public interface DoctorService {

	DoctorResponce createDoctor(DoctorRequest doctorRequest);
	DoctorResponce findById(Integer id);
}
