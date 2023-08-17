package com.cloudfy.email.controllers;

import com.cloudfy.email.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping(value = "/email/send")
public class EmailController {

    @Autowired
    private EmailService service;
}
