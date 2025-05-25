package com.example.server2.controller;

import com.example.common.dto.ScheduleDto;
import com.example.server2.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
//
//    // 전체 일정 조회
//    @GetMapping
//    public List<ScheduleDto> getAllSchedules() {
//        return scheduleService.getSchedules();
//    }
//
//    // ID로 일정 조회
//    @GetMapping("/{id}")
//    public ScheduleDto getScheduleById(@PathVariable Long id) {
//        return scheduleService.getScheduleById(id);
//    }
//
//    // 일정 등록
//    @PostMapping
//    public int createSchedule(@RequestBody ScheduleDto scheduleDto) {
//        return scheduleService.createSchedule(scheduleDto);
//    }
//
//    // 일정 수정
//    @PutMapping("/{id}")
//    public int updateSchedule(@PathVariable Long id, @RequestBody ScheduleDto scheduleDto) {
//        scheduleDto.setId(id);  // 경로 id를 DTO에 세팅
//        return scheduleService.updateSchedule(scheduleDto);
//    }
//
//    // 일정 삭제
//    @DeleteMapping("/{id}")
//    public int deleteSchedule(@PathVariable Long id) {
//        return scheduleService.deleteSchedule(id);
//    }
}
