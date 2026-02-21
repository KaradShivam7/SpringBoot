package com.mail.mailsender.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mail.mailsender.Entity.Student;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class Mailsender_service {
	
	@Autowired
	JavaMailSender sender;
	
	
	public String sendMessage(String useremail) {
		SimpleMailMessage message=new SimpleMailMessage();
		
		message.setTo(useremail);
		message.setFrom("shivamkarad29@gmail.com");
		message.setSubject("Placement update");
		message.setText("hii from shivam");
		
		
		System.out.println("sending the mail..................................");
		sender.send(message);
		
		return "mail sent successfully";
	}
	
	public String sendMIMEMessage(Student student) throws MessagingException {
		
		MimeMessage mime=sender.createMimeMessage();
		MimeMessageHelper helper =new MimeMessageHelper(mime,true,"UTF-8");
		
		String htmlCard = """
<html>
<body style="margin:0; padding:20px; background:#f4f4f4; font-family:Arial, sans-serif;">

  <table width="100%" cellpadding="0" cellspacing="0">
    <tr>
      <td align="center">
        
        <table width="500" cellpadding="0" cellspacing="0" style="background:#ffffff; padding:30px; border-radius:8px;">
          
          <tr>
            <td style="font-size:22px; font-weight:bold; padding-bottom:15px; text-align:center;">
              Welcome 🎉
            </td>
          </tr>
          
          <tr>
            <td style="font-size:14px; color:#333333; line-height:1.6; text-align:center;">
              Hello {{name}},<br><br>
              Welcome to {{company_name}}!  
              We're excited to have you with us.
              <br><br>
              If you have any questions, feel free to reach out.
            </td>
          </tr>

        </table>

      </td>
    </tr>
  </table>

</body>
</html>""";

		helper.setTo(student.getStudentemail());
		helper.setFrom("shivamkard29@gmail.com");
		helper.setText(htmlCard,true);
		helper.setSubject("demo");
		
		sender.send(mime);
		
		return "mail sent";
				
		
	}

}
