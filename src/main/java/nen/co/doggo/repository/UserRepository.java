package nen.co.doggo.repository;

import nen.co.doggo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> getUserEntityByUsername(String username);

    boolean existsByUsername(String username);

}
