package com.pixeon.challenge.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pixeon.challenge.domain.model.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

}
