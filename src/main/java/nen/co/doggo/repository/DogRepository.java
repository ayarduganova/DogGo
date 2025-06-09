package nen.co.doggo.repository;

import nen.co.doggo.entity.DogEntity;
import nen.co.doggo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DogRepository extends JpaRepository<DogEntity, Long> {

    List<DogEntity> getDogEntitiesByOwner(UserEntity user);

    Optional<DogEntity> getDogEntityById(Long id);
}
