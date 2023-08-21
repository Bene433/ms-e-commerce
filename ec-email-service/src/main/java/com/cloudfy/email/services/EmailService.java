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
            message.setFrom("matheusbenediht.smtp@gmail.com");
            message.setTo(email.getEmailTo());
            message.setSubject("Seu cadastro foi concluído com sucesso.");
            message.setText("É com grande alegria que lhe damos as boas-vindas à nossa comunidade no [Nome do E-commerce]! Agradecemos sinceramente por ter escolhido se cadastrar conosco e confiar em nossos produtos e serviços. Estamos ansiosos para proporcionar a você uma experiência única de compras online.\n" +
                    "\n" +
                    "Seu cadastro foi concluído com sucesso, e agora você faz parte de nossa plataforma, onde encontrará uma ampla seleção de produtos incríveis, promoções especiais e um atendimento dedicado para tornar sua jornada de compras ainda mais satisfatória.");
            emailSender.send(message);

            email.setStatus(StatusEmail.SENT);
        }catch (MailException e){
            email.setStatus(StatusEmail.ERROR);
        }finally {
            return repository.save(email);
        }
    }

}