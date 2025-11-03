package com.Audience.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Audience.Entity.OfflineConference;

@Repository
public interface OfflineConferenceRepository extends JpaRepository<OfflineConference, Long> {
}
