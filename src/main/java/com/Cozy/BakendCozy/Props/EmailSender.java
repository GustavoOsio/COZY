package com.Cozy.BakendCozy.Props;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;

import java.util.Properties;

public class EmailSender {
	
	@Value("${spring.mail.host}")
	private static String hostS;

	@Value("${spring.mail.port}")
	private static int portS;

	@Value("${spring.mail.username}")
	private static String usernameS;

	@Value("${spring.mail.password}")
	private static String passwordS;

	  public static void sendEmail(String recipientEmail, String subject, String body) {
	        // Configuración del servidor SMTP y credenciales
	        String host = "smtp.gmail.com";
	        int port =  587;
	        String username = "osiogustavosalazar1@gmail.com";
	        String password = "Osio2708@";

	        // Propiedades de la sesión
	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.port", port);

	        // Autenticación del remitente
	        Authenticator authenticator = new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(username, password);
	            }
	        };

	        // Creación de la sesión de correo
	        Session session = Session.getInstance(props, authenticator);

	        try {
	            // Creación del mensaje de correo
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(username));
	            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
	            message.setSubject(subject);
	            message.setText(body);

	            // Envío del mensaje
	            Transport.send(message);

	            System.out.println("Correo enviado exitosamente");
	        } catch (MessagingException e) {
	            System.out.println("Error al enviar el correo: " + e.getMessage());
	        }
	    }

	
}
