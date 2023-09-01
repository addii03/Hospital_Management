package hospital_management.request;

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
public class PatientRequest {
	Integer id;
	String name;
	String address;
	Integer age;
	String email;
	String phoneNumber;
	
	Integer appointmentId;
}
