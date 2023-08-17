package com.cloudfy.email.models.dto;

import com.cloudfy.email.models.enums.StatusEmail;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {

    @NotBlank
    private String ownerRef;
    @NotBlank
    @Email
    private String emailFrom;
    @Email
    @NotBlank
    private String emailTo;
    @NotBlank
    private String subject;
    @NotBlank
    private String text;

}