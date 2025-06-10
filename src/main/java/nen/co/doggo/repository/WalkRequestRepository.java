package nen.co.doggo.repository;

import nen.co.doggo.entity.WalkRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalkRequestRepository extends JpaRepository<WalkRequestEntity, Long> {
    List<WalkRequestEntity> findByWalkerId(Long walkerId);
    List<WalkRequestEntity> findByUserId(Long userId);
}
