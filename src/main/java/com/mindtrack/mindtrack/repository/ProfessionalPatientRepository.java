package com.mindtrack.mindtrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtrack.mindtrack.entity.ProfessionalPatientEntity;

@Repository
public interface ProfessionalPatientRepository extends JpaRepository<ProfessionalPatientEntity, Long>{
    
}
