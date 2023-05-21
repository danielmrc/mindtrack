package com.mindtrack.mindtrack.controller.impl;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtrack.mindtrack.controller.PatientController;
import com.mindtrack.mindtrack.model.dto.PatientDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PatientControllerImpl implements PatientController{

    @Override
    @PostMapping("/patient/{crp}")
    ResponseEntity<?> createPatient(@PathVariable String professionalId, @RequestBody PatientDTO request) {

    }

    @Override
    @PutMapping("/patient/{cpf}")
    ResponseEntity<?> updatePatient(@PathVariable String id, @RequestBody PatientDTO request) {

    }

    @Override
    @DeleteMapping("/patient/{crp}/{cpf}")
    ResponseEntity<?> deletePatient(@PathVariable String professionalId, @PathVariable String id) {

    }
    
    @Override
    @GetMapping("/patient/{crp}/{cpf}")
    ResponseEntity<?> selectPatient(@PathVariable String professionalId, @PathVariable String id) {

    }
    
}
