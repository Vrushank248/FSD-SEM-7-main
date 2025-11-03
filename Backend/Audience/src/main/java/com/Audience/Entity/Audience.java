package com.Audience.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "audience")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "audience_type", discriminatorType = DiscriminatorType.STRING)
public class Audience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audience_id")
    private Long audience_id;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "affilation")
    private String affilation;

    @Column(name = "phone_no")
    private String phone_no;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "audience_interest",
            joinColumns = @JoinColumn(name = "audience_id"),
            inverseJoinColumns = @JoinColumn(name = "interest_id")
    )
    private List<Interest> interests = new ArrayList<>();

    @OneToOne(mappedBy = "audience", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Profile userProfile;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "conference_id", referencedColumnName = "id")
    private Conference conference;

    // Getters and setters (same as preexisting)
    public Long getAudience_id() {
        return audience_id;
    }

    public void setAudience_id(Long audience_id) {
        this.audience_id = audience_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAffilation() {
        return affilation;
    }

    public void setAffilation(String affilation) {
        this.affilation = affilation;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }

    public void addInterest(Interest interest) {
        if (!interests.contains(interest)) {
            interests.add(interest);
            interest.getAudiences().add(this);
        }
    }

    public void removeInterest(Interest interest) {
        if (interests.contains(interest)) {
            interests.remove(interest);
            interest.getAudiences().remove(this);
        }
    }

    public Profile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(Profile userProfile) {
        this.userProfile = userProfile;
        if (userProfile != null) {
            userProfile.setAudience(this);
        }
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }
}
