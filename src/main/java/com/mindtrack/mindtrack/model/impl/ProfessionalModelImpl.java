package com.mindtrack.mindtrack.model.impl;

import org.springframework.stereotype.Service;

import com.mindtrack.mindtrack.model.ProfessionalModel;
import com.mindtrack.mindtrack.model.dto.ProfessionalDTO;
import com.mindtrack.mindtrack.model.dto.SucessModel;
import com.mindtrack.mindtrack.repository.ProfessionalRepository;
import com.mindtrack.mindtrack.entity.ProfessionalEntity;
import com.mindtrack.mindtrack.exception.CreateException;
import com.mindtrack.mindtrack.exception.UpdateException;
import com.mindtrack.mindtrack.exception.DeleteException;
import com.mindtrack.mindtrack.exception.SelectException;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

import lombok.RequiredArgsConstructor;

import static com.mindtrack.mindtrack.constant.AppConstant.SUCESS_CREATING_MESSAGING;
import static com.mindtrack.mindtrack.constant.AppConstant.SUCESS_UPDATING_MESSAGING;
import static com.mindtrack.mindtrack.constant.AppConstant.ERROR_CREATING_MESSAGING;
import static com.mindtrack.mindtrack.constant.AppConstant.ERROR_UPDATING_MESSAGING;
import static com.mindtrack.mindtrack.constant.AppConstant.SUCESS_DELETING_MESSAGING;
import static com.mindtrack.mindtrack.constant.AppConstant.SUCESS_SELECTING_MESSAGING;
import static com.mindtrack.mindtrack.constant.AppConstant.ERROR_DELETING_MESSAGING;
import static com.mindtrack.mindtrack.constant.AppConstant.ERROR_SELECTING_MESSAGING;

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
            .orElseThrow(() -> new UpdateException(String.format(ERROR_UPDATING_MESSAGING, "Professional", "Professional not found")));

        professionalEntity.setCrp(request.getCrp());
        professionalEntity.setDateOfBirth(LocalDate.parse(request.getDateOfBirth(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        professionalEntity.setEmailAddress(request.getEmailAddress());
        professionalEntity.setName(request.getName());
        professionalEntity.setPhoneNumber(request.getPhoneNumber());

        try{
            professionalRepository.save(professionalEntity);

            return SucessModel.builder()
                .description(String.format(SUCESS_UPDATING_MESSAGING, "Professional"))
                .object(request).build();
        } catch (Exception e) {
            throw new UpdateException(String.format(ERROR_UPDATING_MESSAGING, "Professional", e.getMessage()));
        }
    }

    @Override
    public SucessModel deleteProfessional(String id) {
        try {
            professionalRepository.deleteById(id);

            return SucessModel.builder()
                .description(String.format(SUCESS_DELETING_MESSAGING, "Professional")).build();
        } catch (Exception e) {
            throw new DeleteException(String.format(ERROR_DELETING_MESSAGING, "Professiona", e.getMessage()));
        }
    }

    @Override
    public SucessModel selectProfessional(String id) {
        try{
            var professional = professionalRepository.findById(id);

            if(professional.isPresent()) {
                var professionalDTO = ProfessionalDTO.builder()
                    .crp(professional.get().getCrp())
                    .dateOfBirth(professional.get().getDateOfBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                    .emailAddress(professional.get().getEmailAddress())
                    .phoneNumber(professional.get().getPhoneNumber())
                    .name(professional.get().getName()).build();

                    return SucessModel.builder()
                        .description(String.format(SUCESS_SELECTING_MESSAGING, "Professional"))
                        .object(professionalDTO).build();
            }

            return null;
        } catch (Exception e) {
            throw new SelectException(String.format(ERROR_SELECTING_MESSAGING, "Professiona", e.getMessage()));
        }
    }
    
}
