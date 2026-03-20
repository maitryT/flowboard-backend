package com.demo.flowboard_backend.repository;

import com.demo.flowboard_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

}
