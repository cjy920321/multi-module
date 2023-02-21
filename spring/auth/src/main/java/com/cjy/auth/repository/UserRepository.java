package com.cjy.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cjy.auth.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
