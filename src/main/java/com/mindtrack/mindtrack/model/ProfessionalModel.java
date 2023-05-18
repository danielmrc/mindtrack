package com.mindtrack.mindtrack.model;

import com.mindtrack.mindtrack.model.dto.ProfessionalDTO;
import com.mindtrack.mindtrack.model.dto.SucessModel;

public interface ProfessionalModel {

    SucessModel insertProfessional(ProfessionalDTO request);

    SucessModel updateProfessional(String id, ProfessionalDTO request);
    
}
