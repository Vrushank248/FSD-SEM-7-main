package com.Audience.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "interest")
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interest_id")
    private Long interestId;

    @Column(name = "interest_name", unique = true, nullable = false)
    private String interestName;

    @Column(name = "description")
    private String description;

    @Column(name = "category", nullable = false)
    private String category;

    @ManyToMany(mappedBy = "interests", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Audience> audiences = new ArrayList<>();

    public Interest() {
    }

    public Interest(String interestName, String description, String category) {
        this.interestName = interestName;
        this.description = description;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getInterestId() {
        return interestId;
    }

    public void setInterestId(Long interestId) {
        this.interestId = interestId;
    }

    public String getInterestName() {
        return interestName;
    }

    public void setInterestName(String interestName) {
        this.interestName = interestName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Audience> getAudiences() {
        return audiences;
    }

    public void setAudiences(List<Audience> audiences) {
        this.audiences = audiences;
    }

    // Helper methods for bidirectional relationship management
    public void addAudience(Audience audience) {
        if (!audiences.contains(audience)) {
            audiences.add(audience);
            audience.getInterests().add(this);
        }
    }

    public void removeAudience(Audience audience) {
        if (audiences.contains(audience)) {
            audiences.remove(audience);
            audience.getInterests().remove(this);
        }
    }

    @Override
    public String toString() {
        return "Interest{"
                + "interestId=" + interestId
                + ", interestName='" + interestName + '\''
                + ", category='" + category + '\''
                + '}';
    }
}
