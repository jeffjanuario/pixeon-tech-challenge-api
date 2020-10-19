package com.pixeon.challenge.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pixeon.challenge.domain.model.Exam;
import com.pixeon.challenge.domain.model.HealthcareInstitution;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
	List<Exam> findByHealthcare(HealthcareInstitution healthcare);
}
