package com.cloudfy.email.services;

import com.cloudfy.email.models.dto.EmailDTO;
import com.cloudfy.email.models.entities.EmailEntity;
import com.cloudfy.email.models.enums.StatusEmail;
import com.cloudfy.email.repositories.EmailRepository;
import jakarta.validation.constraints.Email;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private EmailRepository repository;

    @Autowired
    private JavaMailSender emailSender;

    public EmailEntity sendEmail(EmailDTO dataDTO){
        EmailEntity email = new EmailEntity();
        BeanUtils.copyProperties(dataDTO, email);
        email.setSendDateEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            emailSender.send(message);

            email.setStatus(StatusEmail.SENT);
        }catch (MailException e){
            email.setStatus(StatusEmail.ERROR);
        }finally {
            return repository.save(email);
        }
    }

}