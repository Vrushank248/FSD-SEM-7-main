package com.Audience.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

import com.Audience.Entity.Audience;
import com.Audience.Service.AudienceService;

// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/audience")
public class AudienceController {

    @Autowired
    private AudienceService audienceService;

    // Get audience by id
    @GetMapping("/{id}")
    public ResponseEntity<Audience> getAudienceById(@PathVariable Long id) {
        Audience audience = audienceService.getAudienceById(id);
        if (audience != null) {
            return ResponseEntity.ok(audience);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get all students
    @GetMapping("/students")
    public List<com.Audience.Entity.StudentAudience> getAllStudents() {
        return audienceService.getAllStudents();
    }

    // Get all professors
    @GetMapping("/professors")
    public List<com.Audience.Entity.ProfessorAudience> getAllProfessors() {
        return audienceService.getAllProfessors();
    }

    // Delete audience by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAudience(@PathVariable Long id) {
        boolean deleted = audienceService.deleteAudience(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/register")
    public Audience registerUser(@RequestBody Audience audience) {
        return audienceService.registerUser(audience);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password) {
        Audience audience = audienceService.loginUser(email, password);
        if (audience != null) {
            return ResponseEntity.ok(audience);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

    @PutMapping("/update-profile/{id}")
    public Audience updateProfile(@PathVariable Long id, @RequestBody Audience audience) {
        return audienceService.updateProfile(id, audience);
    }

}
