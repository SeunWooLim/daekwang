package kr.or.daekwang.member.controller;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuth extends Authenticator{
	
	PasswordAuthentication pa;
    
    public MailAuth() {
        String mail_id = "daekwangchurch";
        String mail_pw = "daekwang123";
        
        pa = new PasswordAuthentication(mail_id, mail_pw);
    }
    
    public PasswordAuthentication getPasswordAuthentication() {
        return pa;
    }
}
