package com.cloudfy.email.models.entities;

import com.cloudfy.email.models.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_email")
public class EmailEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String emailTo;
    private String subject;
    private LocalDateTime sendDateEmail;
    private StatusEmail status;

}