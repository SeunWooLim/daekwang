package kr.or.daekwang.member.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSend {
	 
	public void mailSend(String mail, String tempPwd) {
	        Properties prop = System.getProperties();
	        prop.put("mail.smtp.starttls.enable", "true");
	        prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.port", "587");
	        
	        Authenticator auth = new MailAuth();
	        
	        Session session = Session.getDefaultInstance(prop, auth);
	        
	        MimeMessage msg = new MimeMessage(session);
	        String text = "대광교회 홈페이지를 이용해주셔서 진심으로 감사드립니다. 회원님의 임시 비밀번호는 ' " + tempPwd + " ' 입니다. 해당 비밀번호로 로그인 후 비밀번호를 변경하여 주시기 바랍니다. 감사합니다."; 
	    
	        try {
	            msg.setSentDate(new Date());
	            
	            msg.setFrom(new InternetAddress(mail, "대광교회"));
	            InternetAddress to = new InternetAddress(mail);         
	            msg.setRecipient(Message.RecipientType.TO, to);            
	            msg.setSubject("대광교회 - 임시 비밀번호 발급", "UTF-8");            
	            msg.setText(text, "UTF-8");            
	            
	            Transport.send(msg);
	            
	        } catch(AddressException ae) {            
	        	ae.printStackTrace();
	            System.out.println("AddressException : " + ae.getMessage());           
	        } catch(MessagingException me) {
	        	me.printStackTrace();
	            System.out.println("MessagingException : " + me.getMessage());
	        } catch(UnsupportedEncodingException e) {
	        	e.printStackTrace();
	            System.out.println("UnsupportedEncodingException : " + e.getMessage());			
	        }
	                
	    }
}
