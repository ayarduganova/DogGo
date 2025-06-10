package nen.co.doggo.service;

import lombok.RequiredArgsConstructor;
import nen.co.doggo.dto.req.DogRequest;
import nen.co.doggo.entity.DogEntity;
import nen.co.doggo.entity.UserEntity;
import nen.co.doggo.mapper.DogMapper;
import nen.co.doggo.repository.DogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DogService {

    private final DogRepository dogRepository;
    private final DogMapper dogMapper;


    public List<DogEntity> getDogsByUser(UserEntity user) {
        return dogRepository.getDogEntitiesByOwner(user);
    }

    public DogEntity getDogById(Long dogId) {
        return dogRepository.getDogEntityById(dogId).get();
    }

    public void addDog(UserEntity user, DogRequest dogRequest) {
        DogEntity dogEntity = dogMapper.toEntity(dogRequest);
        dogEntity.setOwner(user);
        List<DogEntity> dogs = user.getDogs();
        dogs.add(dogEntity);
        user.setDogs(dogs);
        dogRepository.save(dogEntity);
    }

    public void editDog(Long dogId, DogRequest dogRequest) {
        DogEntity dogEntity = getDogById(dogId);
        dogRepository.save(dogMapper.updateEntityFromRequest(dogRequest, dogEntity));
    }

}
