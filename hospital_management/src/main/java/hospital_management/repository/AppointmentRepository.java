package hospital_management.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hospital_management.entity.Appointment;
import hospital_management.entity.Doctor;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer>{

	List<Appointment> findByDoctorAndAppointmentDate (Doctor doctor, LocalDate appointmentDate);
	//List<Appointment> findUpcomingAppointments();
	//List<Appointment> findByDoctorAndAppointmentTime(Doctor doctor, LocalDateTime appointmentTime);
		
	 @Query("SELECT a FROM Appointment a WHERE a.appointmentDate > CURRENT_TIMESTAMP")
	    List<Appointment> findUpcomingAppointments();
}
