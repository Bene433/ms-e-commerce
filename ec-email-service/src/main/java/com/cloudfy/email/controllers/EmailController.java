package com.cloudfy.email.controllers;

import com.cloudfy.email.models.dto.EmailDTO;
import com.cloudfy.email.models.entities.EmailEntity;
import com.cloudfy.email.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping(value = "/email/send")
public class EmailController {

    @Autowired
    private EmailService service;

    @PostMapping
    public ResponseEntity<EmailEntity> sendingEmail(@RequestBody @Valid EmailDTO data){
        EmailEntity email = service.sendEmail(data);
        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }
}