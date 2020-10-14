package com.pixeon.challenge.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pixeon.challenge.domain.model.Bugdet;

@Repository
public interface BugdetRepository extends JpaRepository<Bugdet, Long> {
}
