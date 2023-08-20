package com.cloudfy.email.consumers;

import com.cloudfy.email.models.dto.EmailDTO;
import com.cloudfy.email.models.entities.EmailEntity;
import com.cloudfy.email.services.EmailService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDTO emailDTO) {
        EmailEntity email = emailService.sendEmail(emailDTO);
        System.out.println("E-mail status: " + email.getStatus());
    }

}