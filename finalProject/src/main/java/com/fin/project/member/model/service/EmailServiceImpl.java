package com.fin.project.member.model.service;

import java.util.HashMap;
import java.util.Map;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fin.project.member.model.dao.EmailDAO;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailDAO dao;
	
	@Autowired
	private JavaMailSender mailSender;
	
	private String fromEmail = "jw1402480140@gmail.com";
	private String fromUsername = "Java Library";
	
	@Override
	public String createAuthKey() {
		
		String key = "";
		
        for(int i=0; i<6; i++) {
            
            int sel1 = (int)(Math.random() * 3);
            
            if(sel1 == 0) {
                int num = (int)(Math.random() * 10);
                key += num;
                
            }else {
                char ch = (char)(Math.random() * 26 + 'A');
                
                int sel2 = (int)(Math.random() * 2);
                
                if(sel2 == 0) {
                    ch = (char)(ch + ('a' - 'A'));
                }
                
                key += ch;
            }
        }
		
		return key;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int signUp(String email, String title) {
		
		String authKey = createAuthKey();
		
		try {
			
			MimeMessage mail = mailSender.createMimeMessage();
			
			String subject = "[Java Library] " + title + " 인증코드";
			
			String charset = "UTF-8";
			
			String mailContent
				= "<p>Java Library " + title + " 인증코드입니다. </p>"
				+ "<h3 style='color:blue'>" + authKey + "</h3>";
			
			mail.setFrom(new InternetAddress(fromEmail, fromUsername));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            
            mail.setSubject(subject, charset);
            
            mail.setText(mailContent, charset, "html"); //"html" 추가 시 HTML 태그가 해석됨
            
            mailSender.send(mail);
			
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		Map<String, String> map = new HashMap<String, String>();
        map.put("authKey", authKey);
        map.put("email", email);
        
        int result = dao.updateAuthKey(map);
        
        if(result == 0) {
           result = dao.insertAuthKey(map);
        }

        return result;
	}

	@Override
	public int checkAuthKey(Map<String, Object> paramMap) {
		return dao.checkAuthKey(paramMap);
	}
	
}
