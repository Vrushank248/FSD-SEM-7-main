package com.Audience.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Audience.Entity.Audience;

@Repository
public interface AudienceRepository extends JpaRepository<Audience, Long> {

    Optional<Audience> findByEmail(String email);

}
