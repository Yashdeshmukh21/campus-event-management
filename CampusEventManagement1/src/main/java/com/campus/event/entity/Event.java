package com.campus.event.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String category;

    // 🔹 Default Constructor
    public Event() {
    }

    // 🔹 Parameterized Constructor (All fields)
    public Event(Long id, String title, String description, String location, String date, String category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.date = date;
        this.category = category;
    }

    // 🔹 Parameterized Constructor (Without ID)
    public Event(String title, String description, String location, String date, String category) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.date = date;
        this.category = category;
    }

    // 🔹 Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // 🔹 toString()
    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
