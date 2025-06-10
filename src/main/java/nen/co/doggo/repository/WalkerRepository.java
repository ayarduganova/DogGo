package nen.co.doggo.repository;

import nen.co.doggo.entity.UserEntity;
import nen.co.doggo.entity.WalkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalkerRepository extends JpaRepository<WalkerEntity, Long> {

    Optional<WalkerEntity> getWalkerEntityById(Long id);

    Optional<WalkerEntity> getWalkerEntityByUser(UserEntity user);
}
