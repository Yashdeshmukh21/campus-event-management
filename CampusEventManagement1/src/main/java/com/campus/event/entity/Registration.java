package com.campus.event.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "registrations")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Each registration is linked to one user
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Each registration is linked to one event
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    // 🔹 Default Constructor
    public Registration() {
    }

    // 🔹 Parameterized Constructor (All fields)
    public Registration(Long id, User user, Event event) {
        this.id = id;
        this.user = user;
        this.event = event;
    }

    // 🔹 Parameterized Constructor (Without ID)
    public Registration(User user, Event event) {
        this.user = user;
        this.event = event;
    }

    // 🔹 Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    // 🔹 toString()
    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", user=" + (user != null ? user.getName() : "null") +
                ", event=" + (event != null ? event.getTitle() : "null") +
                '}';
    }
}
