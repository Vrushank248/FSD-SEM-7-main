package com.Audience.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Audience.Entity.OnlineConference;

@Repository
public interface OnlineConferenceRepository extends JpaRepository<OnlineConference, Long> {
}
