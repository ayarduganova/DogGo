package nen.co.doggo.mapper;

import lombok.RequiredArgsConstructor;
import nen.co.doggo.dto.req.WalkerRequest;
import nen.co.doggo.entity.ScheduleEntity;
import nen.co.doggo.entity.UserEntity;
import nen.co.doggo.entity.WalkerEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WalkerMapper {

    public WalkerEntity toEntity(WalkerRequest walkerRequest, ScheduleEntity schedule, UserEntity user) {
        WalkerEntity walker = WalkerEntity.builder()
                .user(user)
                .workExperience(walkerRequest.workExperience())
                .workArea(walkerRequest.workArea())
                .price(walkerRequest.price())
                .schedule(schedule)
                .build();

        user.setWalker(walker);

        return walker;
    }

}
