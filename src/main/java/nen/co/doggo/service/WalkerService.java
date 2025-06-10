package nen.co.doggo.service;

import lombok.RequiredArgsConstructor;
import nen.co.doggo.dto.req.ScheduleRequest;
import nen.co.doggo.dto.req.WalkerRequest;
import nen.co.doggo.entity.ScheduleEntity;
import nen.co.doggo.entity.UserEntity;
import nen.co.doggo.mapper.ScheduleMapper;
import nen.co.doggo.mapper.WalkerMapper;
import nen.co.doggo.repository.ScheduleRepository;
import nen.co.doggo.repository.WalkerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalkerService {

    private final WalkerMapper walkerMapper;
    private final ScheduleMapper scheduleMapper;
    private final WalkerRepository walkerRepository;
    private final ScheduleRepository scheduleRepository;

    public void sendWalkerRequest(UserEntity user, WalkerRequest walkerRequest, ScheduleRequest scheduleRequest) {

        ScheduleEntity schedule = scheduleMapper.toEntity(scheduleRequest);
        schedule = scheduleRepository.save(schedule);

        walkerRepository.save(walkerMapper.toEntity(walkerRequest, schedule, user));
    }

}
