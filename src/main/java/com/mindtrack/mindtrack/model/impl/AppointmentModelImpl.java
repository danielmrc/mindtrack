package com.mindtrack.mindtrack.model.impl;

import org.springframework.stereotype.Service;

import com.mindtrack.mindtrack.entity.AppointmentEntity;
import com.mindtrack.mindtrack.exception.CreateException;
import com.mindtrack.mindtrack.exception.DataNotFoundException;
import com.mindtrack.mindtrack.exception.SelectException;
import com.mindtrack.mindtrack.model.AppointmentModel;
import com.mindtrack.mindtrack.model.dto.SucessModel;
import com.mindtrack.mindtrack.model.dto.AppointmentDTO;
import com.mindtrack.mindtrack.repository.AppointmentRepository;
import com.mindtrack.mindtrack.repository.PatientRepository;
import com.mindtrack.mindtrack.repository.ProfessionalRepository;

import static com.mindtrack.mindtrack.constant.AppConstant.SUCESS_CREATING_MESSAGING;
import static com.mindtrack.mindtrack.constant.AppConstant.SUCESS_UPDATING_MESSAGING;
import static com.mindtrack.mindtrack.constant.AppConstant.ERROR_CREATING_MESSAGING;
import static com.mindtrack.mindtrack.constant.AppConstant.ERROR_UPDATING_MESSAGING;
import static com.mindtrack.mindtrack.constant.AppConstant.SUCESS_DELETING_MESSAGING;
import static com.mindtrack.mindtrack.constant.AppConstant.SUCESS_SELECTING_MESSAGING;
import static com.mindtrack.mindtrack.constant.AppConstant.ERROR_DELETING_MESSAGING;
import static com.mindtrack.mindtrack.constant.AppConstant.ERROR_SELECTING_MESSAGING;

import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentModelImpl implements AppointmentModel{

    private final ProfessionalRepository professionalRepository;
    private final AppointmentRepository appointmentRepository;

    @Override
    public SucessModel createAppointment(String crp, String cpf, AppointmentDTO request) {
        try{
            var professional = professionalRepository.findById(crp);

            if(professional.isPresent() && !professional.get().getPatients().isEmpty()) {
                var patient = professional.get().getPatients().stream().filter(p -> p.getCpf().equals(cpf)).findFirst();

                if(!patient.isEmpty()) {
                    var appointmentEntity = AppointmentEntity.builder()
                        .date(LocalDateTime.parse(request.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")))
                        .inPerson(request.getInPerson())
                        .local(request.getLocal())
                        .paid(request.getPaid())
                        .patient(patient.get())
                        .professional(professional.get())
                        .price(request.getPrice())
                        .recurrence(request.getRecurrence()).build();

                    appointmentRepository.save(appointmentEntity);
                    
                    return SucessModel.builder()
                        .description(String.format(SUCESS_CREATING_MESSAGING, "appointment"))
                        .object(request).build();
                }

                throw new DataNotFoundException("not exists record for this patient relation with professional!");
            }

            throw new DataNotFoundException("professional found!");
        } catch(DataNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new CreateException(String.format(ERROR_CREATING_MESSAGING, "appointment", e.getMessage()));
        }
    }

    @Override
    public SucessModel selectAppointment(String crp) {
        try {
            var professional = professionalRepository.findById(crp);

            if(professional.isPresent() && !professional.get().getAppointments().isEmpty()) {
                List<AppointmentDTO> appointments = new ArrayList<>();

                professional.get().getAppointments().forEach( a -> {
                    appointments.add(AppointmentDTO.builder()
                        .date(a.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")))
                        .inPerson(a.getInPerson())
                        .local(a.getLocal())
                        .paid(a.getPaid())
                        .price(a.getPrice())
                        .recurrence(a.getRecurrence()).build());
                });

                return SucessModel.builder()
                    .description(String.format(SUCESS_SELECTING_MESSAGING, "appointments"))
                    .object(appointments).build();
            }

            throw new DataNotFoundException("professional not found or not having appointments");
        } catch (DataNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new SelectException(String.format(ERROR_SELECTING_MESSAGING, "appointment", e.getMessage()));
        }
    }
    
}
