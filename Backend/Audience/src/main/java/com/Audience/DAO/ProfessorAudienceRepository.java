package com.Audience.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Audience.Entity.ProfessorAudience;

@Repository
public interface ProfessorAudienceRepository extends JpaRepository<ProfessorAudience, Long> {

}
