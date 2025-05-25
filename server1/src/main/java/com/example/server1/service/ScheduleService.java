package com.example.server1.service;

import com.example.common.dto.ScheduleDto;
import com.example.server1.client.ScheduleFeignClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleFeignClient feignClient;

    public ScheduleService(ScheduleFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    public List<ScheduleDto> getAllSchedulesFromServer2() {
        return feignClient.getSchedules();
    }
}
