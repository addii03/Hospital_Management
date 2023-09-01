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
public class AppointmentResponce {
	
	Integer id;
	LocalDate appointmentDate;	
	String reason;
	AppointmentStatus status;
	
	Integer patientId;
	String patientName;
	String patientAddress;
	Integer patientAge;
	String patientEmail;
	String phoneNumber;
	
	Integer doctorId;
	String doctorName;
	String doctorAddress;
}
