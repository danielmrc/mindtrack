package com.mindtrack.mindtrack.controller;

import org.springframework.http.ResponseEntity;

import com.mindtrack.mindtrack.model.dto.ProfessionalDTO;

public interface Controller {

    ResponseEntity<?> createProfessional(ProfessionalDTO request);

    ResponseEntity<?> updateProfessional(String id, ProfessionalDTO request);

    ResponseEntity<?> deleteProfessional(String id);
    
    ResponseEntity<?> selectProfessional(String id);
}
