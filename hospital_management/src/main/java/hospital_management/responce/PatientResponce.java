package hospital_management.responce;

import java.time.LocalDate;

import hospital_management.entity.AppointmentStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PatientResponce {
	Integer id;
	String name;
	String address;
	Integer age;
	String email;
	String phoneNumber;

	//appointment
	Integer appointmentId;
	LocalDate appointmentDate;
	AppointmentStatus status;	
}
