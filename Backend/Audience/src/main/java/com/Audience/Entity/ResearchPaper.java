package com.Audience.Entity;

import jakarta.persistence.Entity;

@Entity
public class ResearchPaper extends Paper {

    private String methodology;
    private String resultsSummary;

    public String getMethodology() {
        return methodology;
    }

    public void setMethodology(String methodology) {
        this.methodology = methodology;
    }

    public String getResultsSummary() {
        return resultsSummary;
    }

    public void setResultsSummary(String resultsSummary) {
        this.resultsSummary = resultsSummary;
    }
}
