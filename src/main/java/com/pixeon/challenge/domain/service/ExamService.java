package com.pixeon.challenge.domain.service;

import java.util.Optional;

import com.pixeon.challenge.domain.model.Exam;

public interface ExamService extends BaseService<Exam> {
	Optional<Exam> findByHealthcare(Long healthcareId, Long examId);
}
