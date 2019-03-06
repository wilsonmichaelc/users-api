package com.wilson.seed.repository;

import com.wilson.seed.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByGuid(String guid);
    User findByEmail(String email);
}