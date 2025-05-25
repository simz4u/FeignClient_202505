package com.example.server1.controller;

import com.example.common.dto.ScheduleDto;
import com.example.server1.client.ScheduleFeignClient;
import com.example.server1.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    private final ScheduleFeignClient scheduleFeignClient;

    @GetMapping("/getSchedules")
    public List<ScheduleDto> getSchedules() {
        return scheduleService.getAllSchedulesFromServer2();
    }


    // POST /api/schedules/add
    @PostMapping("/add")
    public ResponseEntity<String> createSchedule(@RequestBody ScheduleDto scheduleDto) {
        scheduleService.addSchedule(scheduleDto);
        return ResponseEntity.ok("Inserted in server1 and server2");
    }
}
