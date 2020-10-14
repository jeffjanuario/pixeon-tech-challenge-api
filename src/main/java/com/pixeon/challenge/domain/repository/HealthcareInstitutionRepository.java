package com.pixeon.challenge.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pixeon.challenge.domain.model.HealthcareInstitution;

@Repository
public interface HealthcareInstitutionRepository extends JpaRepository<HealthcareInstitution, Long> {
}
