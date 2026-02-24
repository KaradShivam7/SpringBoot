package com.otp.otp_sender.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendOtp(String email, int otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("shivamkarad29@gmail.com");
        message.setTo(email);
        message.setSubject("Your OTP Code");
        message.setText("Your OTP is: " + otp + "\n It is valid for 1 minute.");

        mailSender.send(message);
    }
}