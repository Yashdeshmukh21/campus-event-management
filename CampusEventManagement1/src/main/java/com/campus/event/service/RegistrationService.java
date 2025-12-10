package com.campus.event.service;

import com.campus.event.entity.Event;
import com.campus.event.entity.Registration;
import com.campus.event.entity.User;
import com.campus.event.exception.ResourceNotFoundException;
import com.campus.event.repository.EventRepository;
import com.campus.event.repository.RegistrationRepository;
import com.campus.event.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public RegistrationService(RegistrationRepository registrationRepository,
                               UserRepository userRepository,
                               EventRepository eventRepository) {
        this.registrationRepository = registrationRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public Registration getRegistrationById(Long id) {
        return registrationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registration not found with id: " + id));
    }

    // ✅ FIXED createRegistration
    public Registration createRegistration(Registration registration) {
        // Fetch full user and event data before saving
        Long userId = registration.getUser().getId();
        Long eventId = registration.getEvent().getId();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + eventId));

        registration.setUser(user);
        registration.setEvent(event);

        return registrationRepository.save(registration);
    }

    public Registration updateRegistration(Long id, Registration updated) {
        Registration existing = getRegistrationById(id);
        existing.setUser(updated.getUser());
        existing.setEvent(updated.getEvent());
        return registrationRepository.save(existing);
    }

    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }

    public List<Registration> getRegistrationsByUser(Long userId) {
        return registrationRepository.findByUser_Id(userId);
    }

    public List<Registration> getRegistrationsByEvent(Long eventId) {
        return registrationRepository.findByEvent_Id(eventId);
    }
}
