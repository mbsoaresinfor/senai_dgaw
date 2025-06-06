package com.mbs.notificacaoServices.services;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public void enviar(String corpo, String titulo, String de, String para) {
		System.out.println("enviando email: ");
		try {			
			System.out.println("para: " + para);
			System.out.println("titulo: " + titulo);
			System.out.println("corpo: " + corpo);
			System.out.println("EMail Sent Successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
