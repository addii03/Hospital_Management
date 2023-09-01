package hospital_management.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private final JavaMailSender mailSender;
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
	
	 public void sendAppointmentReminder(String recipientEmail, String subject, String message)
	 {
		 SimpleMailMessage mailMessage = new SimpleMailMessage();
		 mailMessage.setTo(recipientEmail);
		 mailMessage.setSubject(subject);
		 mailMessage.setText(message);
		 
		 mailSender.send(mailMessage);
	 }
	 public void sendEmail(String recipientEmail, String subject, String message) {
	        SimpleMailMessage mailMessage = new SimpleMailMessage();
	        mailMessage.setTo(recipientEmail);
	        mailMessage.setSubject(subject);
	        mailMessage.setText(message);
	        javaMailSender.send(mailMessage);
	    }
}
