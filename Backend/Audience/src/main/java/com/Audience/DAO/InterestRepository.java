package com.Audience.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Audience.Entity.Interest;

public interface InterestRepository extends JpaRepository<Interest, Long> {

    Interest findByInterestName(String interestName);

}
