package com.mindtrack.mindtrack.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Setter
@Getter
public class SucessModel {

    private String description;
    private Object object;
    
}