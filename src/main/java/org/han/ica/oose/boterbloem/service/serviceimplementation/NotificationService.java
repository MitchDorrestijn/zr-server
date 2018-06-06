package org.han.ica.oose.boterbloem.service.serviceimplementation;

import org.han.ica.oose.boterbloem.domain.domainobjects.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class NotificationService {

    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(JwtUser jwtUser) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(jwtUser.getEmail());
        mail.setFrom("oose.boterbloem@gmail.com");
        mail.setSubject("U ben een beheerder geworden");
        mail.setText("Testbericht uit java");

        javaMailSender.send(mail);
    }
}
