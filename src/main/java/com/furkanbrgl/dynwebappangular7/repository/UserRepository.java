package com.furkanbrgl.dynwebappangular7.repository;

import com.furkanbrgl.dynwebappangular7.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}