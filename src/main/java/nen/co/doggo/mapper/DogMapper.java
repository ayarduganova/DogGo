package nen.co.doggo.mapper;

import lombok.RequiredArgsConstructor;
import nen.co.doggo.dto.DogRequest;
import nen.co.doggo.dto.DogResponse;
import nen.co.doggo.entity.DogEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DogMapper implements StandartMapper<DogRequest, DogEntity, DogResponse> {


    @Override
    public DogEntity toEntity(DogRequest dogRequest) {
        return DogEntity.builder()
                .name(dogRequest.name())
                .birthMonth(dogRequest.birthMonth())
                .birthYear(dogRequest.birthYear())
                .breed(dogRequest.breed())
                .build();
    }

    @Override
    public DogEntity updateEntityFromRequest(DogRequest dogRequest, DogEntity dogEntity) {
        dogEntity.setName(dogRequest.name());
        dogEntity.setBirthMonth(dogRequest.birthMonth());
        dogEntity.setBirthYear(dogRequest.birthYear());
        dogEntity.setBreed(dogRequest.breed());
        return dogEntity;
    }

    @Override
    public DogResponse toResponse(DogEntity dogEntity) {
        return null;
    }

}
