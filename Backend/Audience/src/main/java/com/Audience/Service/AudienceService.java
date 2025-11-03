package com.Audience.Service;

import java.util.Optional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Audience.DAO.AudienceRepository;
import com.Audience.DAO.InterestRepository;
import com.Audience.DAO.StudentAudienceRepository;
import com.Audience.DAO.ProfessorAudienceRepository;
import com.Audience.DAO.ConferenceRepository;
import com.Audience.Entity.Audience;
import com.Audience.Entity.Interest;
import com.Audience.Entity.Profile;
import com.Audience.Entity.Conference;
import com.Audience.Entity.StudentAudience;
import com.Audience.Entity.ProfessorAudience;

@Service
public class AudienceService {

    @Autowired
    private AudienceRepository audienceRepository;

    @Autowired
    private InterestRepository interestRepository;

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Autowired
    private StudentAudienceRepository studentAudienceRepository;

    @Autowired
    private ProfessorAudienceRepository professorAudienceRepository;

    public Audience getAudienceById(Long id) {
        return audienceRepository.findById(id).orElse(null);
    }

    public List<StudentAudience> getAllStudents() {
        return studentAudienceRepository.findAll();
    }

    public List<ProfessorAudience> getAllProfessors() {
        return professorAudienceRepository.findAll();
    }

    public boolean deleteAudience(Long id) {
        if (audienceRepository.existsById(id)) {
            audienceRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Audience registerUser(Audience audience) {
        // Store password as plain string (not recommended for production)
        return audienceRepository.save(audience);
    }

    public Audience loginUser(String email, String password) {
        Optional<Audience> user = audienceRepository.findByEmail(email);
        return user.filter(a -> password.equals(a.getPassword())).orElse(null);
    }

    public Audience updateProfile(Long audienceId, Audience updatedAudience) {
        // Handle Conference update
if (updatedAudience.getConference() != null) {
    Conference conference = conferenceRepository.findById(updatedAudience.getConference().getId())
        .orElseThrow(() -> new RuntimeException("Conference not found with id " + updatedAudience.getConference().getId()));
    updatedAudience.setConference(conference);
}
        return audienceRepository.findById(audienceId).map(audience -> {
            // Basic fields
            if (updatedAudience.getFull_name() != null) {
                audience.setFull_name(updatedAudience.getFull_name());
            }
            if (updatedAudience.getAffilation() != null) {
                audience.setAffilation(updatedAudience.getAffilation());
            }
            if (updatedAudience.getPhone_no() != null) {
                audience.setPhone_no(updatedAudience.getPhone_no());
            }

            // Interests
            if (updatedAudience.getInterests() != null) {
                audience.getInterests().clear();

                for (Interest interest : updatedAudience.getInterests()) {
                    Interest managedInterest = interestRepository.findById(interest.getInterestId())
                            .orElseThrow(() -> new RuntimeException("Interest not found with id " + interest.getInterestId()));
                    audience.addInterest(managedInterest);
                }
            }

            // UserProfile
            Profile updatedProfile = updatedAudience.getUserProfile();
            if (updatedProfile != null) {
                Profile existingProfile = audience.getUserProfile();

                if (existingProfile == null) {
                    updatedProfile.setAudience(audience);
                    audience.setUserProfile(updatedProfile);
                } else {
                    if (updatedProfile.getBio() != null) {
                        existingProfile.setBio(updatedProfile.getBio());
                    }
                    if (updatedProfile.getLinkedinUrl() != null) {
                        existingProfile.setLinkedinUrl(updatedProfile.getLinkedinUrl());
                    }
                    if (updatedProfile.getTwitterHandle() != null) {
                        existingProfile.setTwitterHandle(updatedProfile.getTwitterHandle());
                    }
                    if (updatedProfile.getWebsite() != null) {
                        existingProfile.setWebsite(updatedProfile.getWebsite());
                    }
                    if (updatedProfile.getDateOfBirth() != null) {
                        existingProfile.setDateOfBirth(updatedProfile.getDateOfBirth());
                    }
                    if (updatedProfile.getAddress() != null) {
                        existingProfile.setAddress(updatedProfile.getAddress());
                    }
                    if (updatedProfile.getCity() != null) {
                        existingProfile.setCity(updatedProfile.getCity());
                    }
                    if (updatedProfile.getCountry() != null) {
                        existingProfile.setCountry(updatedProfile.getCountry());
                    }
                    if (updatedProfile.getProfilePictureUrl() != null) {
                        existingProfile.setProfilePictureUrl(updatedProfile.getProfilePictureUrl());
                    }
                }
            }

            return audienceRepository.save(audience);
        }).orElse(null);
    }

    public Audience addInterestToAudience(Long audienceId, Long interestId) {
        Audience audience = audienceRepository.findById(audienceId)
                .orElseThrow(() -> new RuntimeException("Audience not found with id " + audienceId));
        Interest interest = interestRepository.findById(interestId)
                .orElseThrow(() -> new RuntimeException("Interest not found with id " + interestId));

        audience.addInterest(interest);
        return audienceRepository.save(audience);
    }

    public Audience removeInterestFromAudience(Long audienceId, Long interestId) {
        Audience audience = audienceRepository.findById(audienceId)
                .orElseThrow(() -> new RuntimeException("Audience not found with id " + audienceId));
        Interest interest = interestRepository.findById(interestId)
                .orElseThrow(() -> new RuntimeException("Interest not found with id " + interestId));

        audience.removeInterest(interest);
        return audienceRepository.save(audience);
    }
}
