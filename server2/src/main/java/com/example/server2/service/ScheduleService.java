package com.example.server2.service;

import com.example.common.dto.ScheduleDto;
//import com.example.server2.mapper.ScheduleMapper;
import com.example.server2.mapper.ScheduleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduleService {


    private final ScheduleMapper scheduleMapper;

    public void insertSchedule(ScheduleDto scheduleDto) {
        int result = scheduleMapper.insertSchedule(scheduleDto);
        if (result > 0) {
            log.info("✅ Server2 DB insert 성공: {}", scheduleDto);
        } else {
            log.warn("❌ Server2 DB insert 실패: {}", scheduleDto);
        }
    }
}
