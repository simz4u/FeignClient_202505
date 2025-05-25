package com.example.server1.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.common.dto.ScheduleDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void sendFailedSchedule(ScheduleDto scheduleDto) {
        try {
            String message = objectMapper.writeValueAsString(scheduleDto);
            log.info("[KafkaProducer] 전송할 메시지: {}", message);

            kafkaTemplate.send("schedule-topic", message)
                    .thenAccept(result -> {
                        RecordMetadata metadata = result.getRecordMetadata();
                        log.info("[KafkaProducer] 메시지 전송 성공 - topic: {}, partition: {}, offset: {}",
                                metadata.topic(), metadata.partition(), metadata.offset());
                    })
                    .exceptionally(ex -> {
                        log.error("[KafkaProducer] 메시지 전송 실패", ex);
                        return null;
                    });


        } catch (Exception e) {
            throw new RuntimeException("Kafka 전송 실패", e);
        }
    }

}