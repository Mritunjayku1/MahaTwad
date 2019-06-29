package com.water.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEMailUtil {

	public String userName;
	public String password;
	public String domain;
	public String port;
	public String protocol;
	public String host;
	public String auth;
	public String from;
	public String socketFactoryPort;

	ResourceBundle rb = ResourceBundle.getBundle("resources/mail");

	public SendEMailUtil() {

		/*this.userName = rb.getString("mail.userName");
		this.password = rb.getString("mail.userpassword");
		this.port = rb.getString("mail.port");
		this.from = rb.getString("mail.from");
		this.host = rb.getString("mail.host");
		this.protocol = rb.getString("mail.protocol");
		this.auth = rb.getString("mail.auth");
		this.socketFactoryPort = rb.getString("mail.socketFactory.port");*/
		/*System.out.println(" From : " + from + ", host : " + host
				+ ", userName : " + userName + ", password : " + password);*/

	}

	
	public void sendMail(String to, String subject, String body,
			String attachment, byte[] data) {

		try {
			

		      // Sender's email ID needs to be mentioned
		      String from = "tn.watercon@gmail.com";//change accordingly
		      final String username = "tn.watercon@gmail.com";//change accordingly
		      final String password = "tnwatercon";//change accordingly

		      // Assuming you are sending email through relay.jangosmtp.net
		      String host = "smtp.gmail.com";

		      Properties props = new Properties();
		      props.put("mail.smtp.auth", "true");
		      props.put("mail.smtp.starttls.enable", "true");
		      props.put("mail.smtp.host", host);
		      props.put("mail.smtp.port", "587");
		      props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		      // Get the Session object.
		      Session session = Session.getInstance(props,
		      new javax.mail.Authenticator() {
		         protected PasswordAuthentication getPasswordAuthentication() {
		            return new PasswordAuthentication(username, password);
		         }
		      });

		      try {
		         // Create a default MimeMessage object.
		         Message message = new MimeMessage(session);

		         // Set From: header field of the header.
		         message.setFrom(new InternetAddress(from));

		         // Set To: header field of the header.
		         message.setRecipients(Message.RecipientType.TO,
		         InternetAddress.parse(to));

		         // Set Subject: header field
		         message.setSubject("TWAD- New water supply connection");

		         // Now set the actual message
		         message.setText(body);

		         // Send message
		         Transport.send(message);

		         System.out.println("Sent Mail message successfully....");

		      } catch (MessagingException e) {
		            throw new RuntimeException(e);
		      }
		
			
			
			
			
			
			
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static class HTMLDataSource implements DataSource {
		private String html;

		public HTMLDataSource(String htmlString) {
			html = htmlString;
		}

		// Return html string in an InputStream.
		// A new stream must be returned each time.
		public InputStream getInputStream() throws IOException {
			if (html == null)
				throw new IOException("Null HTML");
			return new ByteArrayInputStream(html.getBytes());
		}

		public OutputStream getOutputStream() throws IOException {
			throw new IOException("This DataHandler cannot write HTML");
		}

		public String getContentType() {
			return "text/html";
		}

		public String getName() {
			return "JAF text/html dataSource to send e-mail only";
		}
	}

}
