package com.example.server2.mapper;

import com.example.common.dto.ScheduleDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ScheduleMapper {

    List<ScheduleDto> selectAllSchedules();

    ScheduleDto selectScheduleById(Long scheduleId);

    int insertSchedule(ScheduleDto scheduleDto);

    int updateSchedule(ScheduleDto scheduleDto);

    int deleteSchedule(Long scheduleId);
}
