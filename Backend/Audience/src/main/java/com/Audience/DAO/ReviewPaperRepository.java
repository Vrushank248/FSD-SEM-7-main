package com.Audience.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Audience.Entity.ReviewPaper;

public interface ReviewPaperRepository extends JpaRepository<ReviewPaper, Long> {
}
