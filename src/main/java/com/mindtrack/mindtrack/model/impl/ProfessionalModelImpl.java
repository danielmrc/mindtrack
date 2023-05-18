package com.mindtrack.mindtrack.model.impl;

import org.springframework.stereotype.Service;

import com.mindtrack.mindtrack.model.ProfessionalModel;
import com.mindtrack.mindtrack.model.dto.ProfessionalDTO;
import com.mindtrack.mindtrack.model.dto.SucessModel;
import com.mindtrack.mindtrack.repository.ProfessionalRepository;
import com.mindtrack.mindtrack.entity.ProfessionalEntity;
import com.mindtrack.mindtrack.exception.CreateException;
import com.mindtrack.mindtrack.exception.UpdateException;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

import lombok.RequiredArgsConstructor;

import static com.mindtrack.mindtrack.constant.AppConstant.SUCESS_CREATING_MESSAGING;
import static com.mindtrack.mindtrack.constant.AppConstant.ERROR_CREATING_MESSAGING;

@Service
@RequiredArgsConstructor
public class ProfessionalModelImpl implements ProfessionalModel{

    private final ProfessionalRepository professionalRepository;

    @Override
    public SucessModel insertProfessional(ProfessionalDTO request) {
        var professional = ProfessionalEntity.builder()
            .crp(request.getCrp())
            .dateOfBirth(LocalDate.parse(request.getDateOfBirth(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
            .emailAddress(request.getEmailAddress())
            .name(request.getName())
            .phoneNumber(request.getPhoneNumber()).build();

        try {
            professionalRepository.save(professional);

            return SucessModel.builder()
                .description(String.format(SUCESS_CREATING_MESSAGING,"Professional"))
                .object(request).build();
        } catch (Exception e) {
            throw new CreateException(String.format(ERROR_CREATING_MESSAGING, "Professional", e.getMessage()));
        }
    }

    @Override
    public SucessModel updateProfessional (String id, ProfessionalDTO request) {
        var professionalEntity = professionalRepository.findById(id)
            .orElseThrow(() -> new UpdateException(""));

        professionalEntity.setCrp(request.getCrp());
        professionalEntity.setDateOfBirth(LocalDate.parse(request.getDateOfBirth(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        professionalEntity.setEmailAddress(request.getEmailAddress());
        professionalEntity.setName(request.getName());
        professionalEntity.setPhoneNumber(request.getPhoneNumber());

        professionalRepository.save(professionalEntity);

        return SucessModel.builder()
            .description("").build();
    }
    
    
}
