package com.Audience.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Audience.Entity.ResearchPaper;
import com.Audience.Entity.ReviewPaper;
import com.Audience.Service.PaperService;

// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/papers")
public class PaperController {

    private final PaperService paperService;

    @Autowired
    public PaperController(PaperService paperService) {
        this.paperService = paperService;
    }

    @GetMapping("/research")
    public List<ResearchPaper> getAllResearchPapers() {
        return paperService.getAllResearchPapers();
    }

    @GetMapping("/review")
    public List<ReviewPaper> getAllReviewPapers() {
        return paperService.getAllReviewPapers();
    }

}
