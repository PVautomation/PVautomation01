package com.pv.project1;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {

	public static void main(String[] args) throws EmailException 
	
	{
		  // Create the attachment
		  EmailAttachment attachment = new EmailAttachment();
		  attachment.setPath("test-output\\emailable-report.html");
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  attachment.setDescription("REPORT3");
		  attachment.setName("REPORT4");

		  // Create the email message
		  MultiPartEmail email = new MultiPartEmail();
		email.attach(attachment);
		
		
		//Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
	    email.setAuthenticator(new DefaultAuthenticator("preethapv01@gmail.com", "preethapv01123"));
		email.setSSLOnConnect(true);
		email.setFrom("preethapv01@gmail.com");
		email.setSubject("SELENIUM TestMail 2");
		email.setMsg("This is a TEST EMAIL");
		email.addTo("preethapv01@gmail.com");
		email.send();
	}

}
