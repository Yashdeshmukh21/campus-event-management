package com.campus.event.controller;

import com.campus.event.entity.Registration;
import com.campus.event.service.RegistrationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
@CrossOrigin(origins = "http://localhost:5173")
public class RegistrationController {

    private final RegistrationService registrationService;

    // Manual constructor
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }

    @GetMapping("/{id}")
    public Registration getRegistrationById(@PathVariable Long id) {
        return registrationService.getRegistrationById(id);
    }

    @PostMapping
    public Registration createRegistration(@RequestBody Registration registration) {
        return registrationService.createRegistration(registration);
    }

    @PutMapping("/{id}")
    public Registration updateRegistration(@PathVariable Long id, @RequestBody Registration registration) {
        return registrationService.updateRegistration(id, registration);
    }

    @DeleteMapping("/{id}")
    public void deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
    }

    @GetMapping("/user/{userId}")
    public List<Registration> getRegistrationsByUser(@PathVariable Long userId) {
        return registrationService.getRegistrationsByUser(userId);
    }

    @GetMapping("/event/{eventId}")
    public List<Registration> getRegistrationsByEvent(@PathVariable Long eventId) {
        return registrationService.getRegistrationsByEvent(eventId);
    }
}
