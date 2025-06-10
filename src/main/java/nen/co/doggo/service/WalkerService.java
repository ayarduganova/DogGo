package nen.co.doggo.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import nen.co.doggo.dto.req.ScheduleRequest;
import nen.co.doggo.dto.req.WalkRequestReq;
import nen.co.doggo.dto.req.WalkerRequest;
import nen.co.doggo.entity.*;
import nen.co.doggo.mapper.ScheduleMapper;
import nen.co.doggo.mapper.WalkerMapper;
import nen.co.doggo.repository.DogRepository;
import nen.co.doggo.repository.ScheduleRepository;
import nen.co.doggo.repository.WalkRequestRepository;
import nen.co.doggo.repository.WalkerRepository;
import nen.co.doggo.security.user.Role;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WalkerService {

    private final WalkerMapper walkerMapper;
    private final ScheduleMapper scheduleMapper;
    private final WalkerRepository walkerRepository;
    private final DogRepository dogRepository;
    private final ScheduleRepository scheduleRepository;
    private final WalkRequestRepository walkRequestRepository;
    private final UserService userService;


    public void sendWalkerRequest(UserEntity user, WalkerRequest walkerRequest, ScheduleRequest scheduleRequest) {

        ScheduleEntity schedule = scheduleMapper.toEntity(scheduleRequest);
        schedule = scheduleRepository.save(schedule);

        walkerRepository.save(walkerMapper.toEntity(walkerRequest, schedule, user));
    }

    public List<WalkerEntity> getApprovedRequests() {
        List<WalkerEntity> walkerEntities = walkerRepository.findAll();
        List<WalkerEntity> approvedRequests = new ArrayList<>();
        for (WalkerEntity walkerEntity : walkerEntities) {
            if(walkerEntity.getStatus().equals(WalkerStatus.APPROVED)) {
                approvedRequests.add(walkerEntity);
            }
        }
        return approvedRequests;
    }

    public HashMap<WalkerEntity, UserEntity> getRequests() {
        List<WalkerEntity> walkerEntities = walkerRepository.findAll();
        HashMap<WalkerEntity, UserEntity> requests = new HashMap<>();
        for (WalkerEntity walkerEntity : walkerEntities) {
            if(walkerEntity.getStatus().equals(WalkerStatus.UNDER_REVIEW)) {
                requests.put(walkerEntity, walkerEntity.getUser());
            }
        }
        return requests;
    }

    public void approveForm(Long walkerId) {
        WalkerEntity walker = walkerRepository.getWalkerEntityById(walkerId).get();
        userService.addRole(walker.getUser(), Role.WALKER);
        walker.setStatus(WalkerStatus.APPROVED);
        walkerRepository.save(walker);
    }

    public void rejectForm(Long walkerId) {
        WalkerEntity walker = walkerRepository.getWalkerEntityById(walkerId).get();
        walkerRepository.delete(walker);
    }

    public WalkerEntity getWalkerByUser(UserEntity user) {
        return walkerRepository.getWalkerEntityByUser(user).get();
    }

    public void bookWalk(UserEntity user, Long walkerId, Long dogId, WalkRequestReq walkRequestReq) {
        WalkerEntity walker = walkerRepository.findById(walkerId)
                .orElseThrow(() -> new EntityNotFoundException("Walker not found"));

        DogEntity dog = dogRepository.findById(dogId)
                .filter(d -> d.getOwner().getId().equals(user.getId()))
                .orElseThrow(() -> new EntityNotFoundException("Dog not found or not owned by user"));

        WalkRequestEntity request = WalkRequestEntity.builder()
                .walker(walker)
                .user(user)
                .dog(dog)
                .walkDateTime(walkRequestReq.walkDateTime())
                .duration(walkRequestReq.duration())
                .status(WalkRequestStatus.PENDING)
                .build();

        walkRequestRepository.save(request);
    }

    public void processWalkRequest(Long requestId, WalkRequestStatus status) {
        WalkRequestEntity request = walkRequestRepository.findById(requestId)
                .orElseThrow(() -> new EntityNotFoundException("Request not found"));

        request.setStatus(status);
        walkRequestRepository.save(request);
    }

    public List<WalkRequestEntity> getWalkRequestsForWalker(Long walkerId) {
        return walkRequestRepository.findByWalkerId(walkerId);
    }

    public List<WalkRequestEntity> getWalkRequestsForUser(Long userId) {
        return walkRequestRepository.findByUserId(userId);
    }
}
