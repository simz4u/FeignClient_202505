package com.example.server1.mapper;

import com.example.common.dto.ScheduleDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScheduleMapper {
    int insertSchedule(ScheduleDto scheduleDto);
}