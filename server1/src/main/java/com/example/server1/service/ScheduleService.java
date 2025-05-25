package com.example.server1.service;

import com.example.common.dto.ScheduleDto;
import com.example.server1.client.ScheduleFeignClient;
import com.example.server1.mapper.ScheduleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleFeignClient feignClient;
    private final ScheduleMapper scheduleMapper;

    public List<ScheduleDto> getAllSchedulesFromServer2() {
        return feignClient.getSchedules();
    }

    @Transactional
    public void addSchedule(ScheduleDto scheduleDto) {
        int inserted = scheduleMapper.insertSchedule(scheduleDto);
        if (inserted > 0) {
            feignClient.insertSchedule(scheduleDto);
        } else {
            throw new RuntimeException("Failed to insert schedule into server1 DB");
        }
    }
}
