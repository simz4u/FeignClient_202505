package com.example.server2.kafka;

import com.example.common.dto.ScheduleDto;
import com.example.server2.mapper.ScheduleMapper;
import com.example.server2.service.ScheduleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final ObjectMapper objectMapper;
    private final ScheduleMapper scheduleMapper;
    private final ScheduleService scheduleService;

    @KafkaListener(topics = "schedule-topic", groupId = "schedule-group")
    public void consume(String message, Acknowledgment ack) {
        log.info("[KafkaConsumer] 메시지 수신: {}", message);
        try {
            ScheduleDto dto = objectMapper.readValue(message, ScheduleDto.class);
            int result = scheduleMapper.insertSchedule(dto);
            if (result > 0) {
                log.info("[KafkaConsumer] DB 삽입 성공: {}", dto);
            } else {
                log.warn("[KafkaConsumer] DB 삽입 실패: {}", dto);
            }
            ack.acknowledge(); // 수동 커밋
        } catch (Exception e) {
            log.error("[KafkaConsumer] 메시지 처리 중 예외 발생", e);
        }
    }

    @KafkaListener(topics = "failed-schedules")
    public void handleFailedInsert(ScheduleDto dto) {
        try {
            scheduleService.insertSchedule(dto);
            log.info("📦 Kafka로 받은 실패 스케줄, 재처리 성공");
        } catch (Exception e) {
            log.error("❌ Kafka 재처리 실패: {}", e.getMessage());
            // 재시도, dead-letter-queue 등 처리 필요
        }
    }
}
