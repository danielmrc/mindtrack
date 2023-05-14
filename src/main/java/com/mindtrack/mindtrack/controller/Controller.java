package com.mindtrack.mindtrack.controller;

import org.springframework.http.ResponseEntity;

import com.mindtrack.mindtrack.model.dto.ProfessionalDTO;

public interface Controller {

    ResponseEntity<Object> createProfessional(ProfessionalDTO request);
    
}
