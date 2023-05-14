package com.mindtrack.mindtrack.controller;

import org.springframework.http.ResponseEntity;

import com.mindtrack.model.ProfessionalDTO;

public interface Controller {

    ResponseEntity<ProfessionalDTO> createProfessional(ProfessionalDTO request);
    
}
