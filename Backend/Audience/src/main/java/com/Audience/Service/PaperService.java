package com.Audience.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Audience.DAO.*;
import com.Audience.Entity.*;

@Service
public class PaperService {

    private final ResearchPaperRepository researchPaperRepository;
    private final ReviewPaperRepository reviewPaperRepository;

    @Autowired
    public PaperService(ResearchPaperRepository researchPaperRepository,
            ReviewPaperRepository reviewPaperRepository) {
        this.researchPaperRepository = researchPaperRepository;
        this.reviewPaperRepository = reviewPaperRepository;
    }

    public ResearchPaper saveResearchPaper(ResearchPaper paper) {
        return researchPaperRepository.save(paper);
    }

    public ReviewPaper saveReviewPaper(ReviewPaper paper) {
        return reviewPaperRepository.save(paper);
    }

    public List<ResearchPaper> getAllResearchPapers() {
        return researchPaperRepository.findAll();
    }

    public List<ReviewPaper> getAllReviewPapers() {
        return reviewPaperRepository.findAll();
    }

}
