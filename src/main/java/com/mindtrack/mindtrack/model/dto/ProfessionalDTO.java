package com.mindtrack.mindtrack.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProfessionalDTO {
    
    public ProfessionalDTO() {}

    private String crp;
    private String name;
    private String phoneNumber;
    private String dateOfBirth;
    private String emailAddress;

}
