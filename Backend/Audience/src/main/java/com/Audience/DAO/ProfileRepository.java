package com.Audience.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Audience.Entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
