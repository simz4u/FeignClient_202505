package com.example.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDto {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Boolean allDay;
    private String location;
    private String organizer;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
