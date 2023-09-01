package hospital_management.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointment")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_id")
	Patient patient;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id")
	Doctor doctor;
	
	@Column(name ="appointment_date")
	LocalDate appointmentDate;
	
	@Column(name ="appointment_reason")
	String reason;	
	
	@Enumerated(EnumType.STRING)
	AppointmentStatus status;
}
