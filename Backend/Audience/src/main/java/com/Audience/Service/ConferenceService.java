package com.Audience.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Audience.DAO.ConferenceRepository;
import com.Audience.DAO.OfflineConferenceRepository;
import com.Audience.DAO.OnlineConferenceRepository;
import com.Audience.Entity.Conference;

@Service
public class ConferenceService {

    private final ConferenceRepository conferenceRepository;
    private final OnlineConferenceRepository onlineConferenceRepository;
    private final OfflineConferenceRepository offlineConferenceRepository;

    @Autowired
    public ConferenceService(ConferenceRepository conferenceRepository,
            OnlineConferenceRepository onlineConferenceRepository,
            OfflineConferenceRepository offlineConferenceRepository) {
        this.conferenceRepository = conferenceRepository;
        this.onlineConferenceRepository = onlineConferenceRepository;
        this.offlineConferenceRepository = offlineConferenceRepository;
    }

    public List<Conference> getAllConferences() {
        List<Conference> all = new ArrayList<>();
        all.addAll(onlineConferenceRepository.findAll());
        all.addAll(offlineConferenceRepository.findAll());
        return all;
    }

    public List<Conference> getAllOnlineConferences() {
        List<Conference> all = new ArrayList<>();
        all.addAll(onlineConferenceRepository.findAll());
        return all;
    }

    public List<Conference> getAllOfflineConferences() {
        List<Conference> all = new ArrayList<>();
        all.addAll(offlineConferenceRepository.findAll());
        return all;
    }

    public Conference getConferenceById(Long id) {
        return conferenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conference not found with id: " + id));
    }

}
