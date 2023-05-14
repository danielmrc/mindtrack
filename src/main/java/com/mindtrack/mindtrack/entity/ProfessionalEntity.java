package com.mindtrack.mindtrack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import static com.mindtrack.mindtrack.constant.AppConstant.SCHEMA;

import java.time.LocalDate;


@Entity(name = "ProfessionalEntity")
@Table(schema = SCHEMA, name = "professional")
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ProfessionalEntity {

    public ProfessionalEntity() {}
    
    @Id
    private String crp;

    @Column(name = "name")
    private String name;
    
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "email_address")
    private String emailAddress;

}
