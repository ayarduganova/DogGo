package nen.co.doggo.repository;

import nen.co.doggo.entity.WalkRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WalkRequestRepository extends JpaRepository<WalkRequestEntity, Long> {
    List<WalkRequestEntity> findByWalkerId(Long walkerId);
    List<WalkRequestEntity> findByUserId(Long userId);
    Optional<WalkRequestEntity> getWalkRequestEntityById(Long userId);
}
