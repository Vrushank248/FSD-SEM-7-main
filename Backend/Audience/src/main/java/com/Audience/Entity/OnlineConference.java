package com.Audience.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class OnlineConference extends Conference {

    @Column(name = "meeting_url")
    private String meetingUrl;

    public String getMeetingUrl() {
        return meetingUrl;
    }

    public void setMeetingUrl(String meetingUrl) {
        this.meetingUrl = meetingUrl;
    }
}
