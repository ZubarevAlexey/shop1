package net.javakg.shop1.data.repo;

import net.javakg.shop1.core.models.entities.BuyerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuyerRepository extends JpaRepository<BuyerEntity, Long> {
    Optional<BuyerEntity> findByName(String name);
}
