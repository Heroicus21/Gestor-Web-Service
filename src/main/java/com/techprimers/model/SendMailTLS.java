/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techprimers.model;

/**
 *
 * @author LucasRoman
 */
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTLS {

	public boolean send(String cliente,String mensaje,String email) {

		final String username = "gestorhotel024@gmail.com";
		final String password = "Luquitas21";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message.setSubject("Encuesta de Satisfaccion");
			message.setText("El cliente "+cliente
				+ "\n\n https://www.e-encuesta.com/s/8ZQWGCPBVGCIfrlICZZTDw/"
                                + "\n\n "+mensaje);

			Transport.send(message);

			System.out.println("Done");
                            return true;
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}

