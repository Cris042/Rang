package com.rang.api.entity.healthUnit;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHealthUnitRepository extends JpaRepository<HealthUnit, Long> 
{
   Optional<HealthUnit> findByName(String name);
   Optional<HealthUnit> findById(Long id);
   Boolean existsByName(String name);
}
