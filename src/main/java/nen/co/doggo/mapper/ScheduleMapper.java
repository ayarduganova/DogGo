package nen.co.doggo.mapper;

import lombok.RequiredArgsConstructor;
import nen.co.doggo.dto.req.ScheduleRequest;
import nen.co.doggo.entity.ScheduleEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScheduleMapper {

    public ScheduleEntity toEntity(ScheduleRequest scheduleRequest) {
        return  ScheduleEntity.builder()
                .mondayFrom(scheduleRequest.mondayFrom())
                .mondayTo(scheduleRequest.mondayTo())
                .tuesdayFrom(scheduleRequest.tuesdayFrom())
                .tuesdayTo(scheduleRequest.tuesdayTo())
                .wednesdayFrom(scheduleRequest.wednesdayFrom())
                .wednesdayTo(scheduleRequest.wednesdayTo())
                .thursdayFrom(scheduleRequest.thursdayFrom())
                .thursdayTo(scheduleRequest.thursdayTo())
                .fridayFrom(scheduleRequest.fridayFrom())
                .fridayTo(scheduleRequest.fridayTo())
                .saturdayFrom(scheduleRequest.saturdayFrom())
                .saturdayTo(scheduleRequest.saturdayTo())
                .sundayFrom(scheduleRequest.sundayFrom())
                .sundayTo(scheduleRequest.sundayTo())
                .build();
    }

}
