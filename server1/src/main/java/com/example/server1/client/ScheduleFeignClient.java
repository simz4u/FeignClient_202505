package com.example.server1.client;

import com.example.common.dto.ScheduleDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "server2-schedule-client", url = "http://localhost:8082")
public interface ScheduleFeignClient {

    @GetMapping("/schedules")
    List<ScheduleDto> getSchedules();


    @PostMapping("/api/schedules/add")
    ScheduleDto insertSchedule(@RequestBody ScheduleDto scheduleDto);

}
