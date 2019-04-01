package com.biz.email.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.biz.email.model.EmailVO;

@Service
public class SendMailService {

	@Autowired
	JavaMailSender javaMailSender;
	
	@Autowired
	ServletContext servletContext;
	
	public void sendMail(EmailVO emailVO) {
		
		String from_email=emailVO.getFrom_email();
		String to_email=emailVO.getTo_email();
		String subject=emailVO.getS_subject();
		String content=emailVO.getS_content();
		String file=emailVO.getS_file1();
		String realPath=servletContext.getRealPath("/files/");
		
		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		//MimeBodyPart messageBodyPart;
		//Multipart multipart;
		try {
			
			mimeMessageHelper=new MimeMessageHelper(mimeMessage, true, "UTF-8");
			mimeMessageHelper.setFrom(from_email);
			mimeMessageHelper.setTo(to_email);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(content);
			/*
			messageBodyPart = new MimeBodyPart();
			multipart = new MimeMultipart();
			
			String file = "path of file to be attached";
		    String fileName = "attachmentName";
		    DataSource source = new FileDataSource(file);
		    
		    messageBodyPart.setDataHandler(new DataHandler(source));
		    messageBodyPart.setFileName(fileName);
		    
		    multipart.addBodyPart(messageBodyPart);
		    */
			
			FileSystemResource resource=new FileSystemResource(realPath+file);
		    mimeMessageHelper.addAttachment(file, resource);
		
		    javaMailSender.send(mimeMessage);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	 

     

     
}























