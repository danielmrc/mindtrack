package com.mindtrack.mindtrack.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtrack.mindtrack.controller.Controller;
import com.mindtrack.mindtrack.model.ProfessionalModel;
import com.mindtrack.mindtrack.model.dto.ErrorModel;
import com.mindtrack.mindtrack.model.dto.ProfessionalDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ControllerImpl implements Controller{

    private final ProfessionalModel professionalModel;

    @PostMapping("/create/professional")
    @Override
    public ResponseEntity<Object> createProfessional(@RequestBody ProfessionalDTO request) {
        try {
            var sucessObject = professionalModel.insertProfessional(request);

            return ResponseEntity.status(200).body(sucessObject);
        } catch (Exception e) {
            var error = ErrorModel.builder()
                .error("DB ERROR")
                .description(String.format(e.getMessage())).build();

            return ResponseEntity.status(422).body(error);
        }
    }
    
    
}
