package com.Audience.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Audience.Entity.StudentAudience;

@Repository
public interface StudentAudienceRepository extends JpaRepository<StudentAudience, Long> {

}
