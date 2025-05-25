package com.example.server1.service;

import com.example.common.dto.ScheduleDto;
import com.example.server1.client.ScheduleFeignClient;
import com.example.server1.kafka.KafkaProducerService;
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
    private final KafkaProducerService kafkaProducerService;

    public List<ScheduleDto> getAllSchedulesFromServer2() {
        return feignClient.getSchedules();
    }

    @Transactional
    public void addSchedule(ScheduleDto scheduleDto) {
        int inserted = scheduleMapper.insertSchedule(scheduleDto);
        if (inserted <= 0) {
            throw new RuntimeException("Server1 DB insert 실패");
        }
        log.info("✅ Server1 DB insert 성공");

        try {
            feignClient.insertSchedule(scheduleDto);
            log.info("✅ Server2 Feign 호출 성공");
        } catch (Exception e) {
            log.warn("❌ Server2 Feign 호출 실패, Kafka로 위임: {}", e.getMessage());
            kafkaProducerService.sendFailedSchedule(scheduleDto); // 실패 처리용 토픽
        }
    }
}
