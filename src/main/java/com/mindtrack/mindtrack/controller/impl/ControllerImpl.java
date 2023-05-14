package com.mindtrack.mindtrack.controller.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtrack.mindtrack.controller.Controller;
import com.mindtrack.mindtrack.entity.ProfessionalEntity;
import com.mindtrack.mindtrack.repository.ProfessionalRepository;
import com.mindtrack.model.ProfessionalDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ControllerImpl implements Controller{

    private final ProfessionalRepository professionalRepository;

    @PostMapping("/create/professional")
    @Override
    public ResponseEntity<ProfessionalDTO> createProfessional(@RequestBody ProfessionalDTO request) {
        var professional = ProfessionalEntity.builder()
            .crp(request.getCrp())
            .dateOfBirth(LocalDate.parse(request.getDateOfBirth(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
            .emailAddress(request.getEmailAddress())
            .name(request.getName())
            .phoneNumber(request.getPhoneNumber()).build();

        try {
            professionalRepository.save(professional);
            return ResponseEntity.status(200).body(request);
        } catch (Exception e) {
            System.out.println(String.format("Error while try create professional in db - exception: %s", e.getMessage()));
            return ResponseEntity.status(422).body(null);
        }
    }
    
    
}
