package com.example.sharingjdbc.repository;

import com.example.sharingjdbc.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tony
 * @describe UserRepository
 * @date 2019-09-15
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
