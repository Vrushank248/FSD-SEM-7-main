package com.Audience.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Audience.Entity.Paper;

public interface PaperRepository extends JpaRepository<Paper, Long> {
}
