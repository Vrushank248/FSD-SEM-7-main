package com.Audience.Entity;

import jakarta.persistence.Entity;

@Entity
public class ReviewPaper extends Paper {

    private String reviewedTopics;
    private Integer numberOfCitations;

    public String getReviewedTopics() {
        return reviewedTopics;
    }

    public void setReviewedTopics(String reviewedTopics) {
        this.reviewedTopics = reviewedTopics;
    }

    public Integer getNumberOfCitations() {
        return numberOfCitations;
    }

    public void setNumberOfCitations(Integer numberOfCitations) {
        this.numberOfCitations = numberOfCitations;
    }
}
