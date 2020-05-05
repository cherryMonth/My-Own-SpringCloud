package com.producer.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.producer.demo.entity.User;

/**
 * @author song
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
