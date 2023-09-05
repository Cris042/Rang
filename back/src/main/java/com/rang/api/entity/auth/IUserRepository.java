package com.rang.api.entity.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> 
{
  Optional<User> findByUsername(String username);
  Boolean existsByUsername(String username);
  Optional<User> findById(long id);
}
