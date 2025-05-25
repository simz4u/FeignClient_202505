package com.example.server1.controller;

import com.example.common.dto.ScheduleDto;
import com.example.server1.service.ScheduleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/schedules")
    public List<ScheduleDto> getSchedules() {
        return scheduleService.getAllSchedulesFromServer2();
    }
}
