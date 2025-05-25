
** DB **
create table FEIGN2_DB.schedule
(
    schedule_id bigint auto_increment
        primary key,
    title       varchar(255)                            not null,
    description text                                    null,
    start_time  datetime                                not null,
    end_time    datetime                                not null,
    all_day     tinyint(1)  default 0                   null,
    location    varchar(255)                            null,
    organizer   varchar(100)                            null,
    status      varchar(50) default 'active'            null,
    created_at  datetime    default current_timestamp() null,
    updated_at  datetime    default current_timestamp() null on update current_timestamp()
);

create index idx_schedule_start_time
    on FEIGN2_DB.schedule (start_time);

create index idx_schedule_status
    on FEIGN2_DB.schedule (status);






** POSTMAN **
http://localhost:8081/api/schedules/add
{
  "title": "주간 회의",
  "description": "개발팀 주간 회의 일정",
  "startTime": "2025-05-27T10:00:00",
  "endTime": "2025-05-27T11:00:00",
  "allDay": false,
  "location": "회의실 A",
  "organizer": "정진수",
  "status": "CONFIRMED",
  "createdAt": "2025-05-25T09:00:00",
  "updatedAt": "2025-05-25T09:00:00"
}