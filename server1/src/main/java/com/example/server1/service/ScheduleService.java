package com.example.server1.service;

import com.example.common.dto.ScheduleDto;
import com.example.server1.client.ScheduleFeignClient;
import com.example.server1.mapper.ScheduleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
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
        try {
            int inserted = scheduleMapper.insertSchedule(scheduleDto);
            if (inserted > 0) {
                log.info("✅ Server1 DB insert 성공: {}", scheduleDto);
                feignClient.insertSchedule(scheduleDto);
                log.info("✅ Server2 API 호출 성공");
            } else {
                log.warn("❌ Server1 DB insert 실패: {}", scheduleDto);
                throw new RuntimeException("Server1 DB insert 실패");
            }
        } catch (Exception e) {
            log.error("❌ 일정 등록 중 오류 발생, 트랜잭션 롤백됨: {}", e.getMessage(), e);
            throw e; // 트랜잭션 롤백 발생
        }
    }
}
