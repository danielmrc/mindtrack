package com.mindtrack.mindtrack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static com.mindtrack.mindtrack.constant.AppConstant.SCHEMA;

@Entity(name = "PatientEntity")
@Table(schema = SCHEMA, name = "patient")
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PatientEntity {

    @Id
    private String cpf;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "responsible")
    private String responsible;
    
}
