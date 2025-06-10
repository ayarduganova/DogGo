package nen.co.doggo.repository;

import nen.co.doggo.entity.WalkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalkerRepository extends JpaRepository<WalkerEntity, Long> {
}
