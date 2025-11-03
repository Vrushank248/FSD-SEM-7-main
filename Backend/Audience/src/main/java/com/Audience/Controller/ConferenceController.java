package com.Audience.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Audience.Entity.Conference;
import com.Audience.Service.ConferenceService;

// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/conferences")
public class ConferenceController {

    private final ConferenceService conferenceService;

    @Autowired
    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @GetMapping
    public List<Conference> getAllConferences() {
        return conferenceService.getAllConferences();
    }

    @GetMapping("/online")
    public List<Conference> getOnlineConferenes() {
        return conferenceService.getAllOnlineConferences();
    }

    @GetMapping("/offline")
    public List<Conference> getOfflinConferences() {
        return conferenceService.getAllOfflineConferences();
    }

    @GetMapping("/{id}")
    public Conference getConferenceById(@PathVariable Long id) {
        return conferenceService.getConferenceById(id);
    }

}
