package com.campus.event.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * EventDTO — Data Transfer Object for Event entity.
 * Used for sending/receiving event data in API responses or requests.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDTO {
    private Long id;
    private String title;
    private String description;
    private String location;
    private String date;
    private String category;
}
