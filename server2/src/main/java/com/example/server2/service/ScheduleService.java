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

    public ScheduleDto insertSchedule(ScheduleDto scheduleDto) {
        int inserted = scheduleMapper.insertSchedule(scheduleDto);
        if (inserted > 0) {
            log.info("✅ Server2 DB insert 성공: {}", scheduleDto);
            return scheduleDto; // 또는 DB에서 다시 조회한 ScheduleDto 반환
        } else {
            log.warn("❌ Server2 DB insert 실패: {}", scheduleDto);
            throw new RuntimeException("DB insert 실패");
        }
    }
}
