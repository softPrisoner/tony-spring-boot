package com.tony.jpa.repository;

import com.tony.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author tony
 * @describe UserRepository
 * @date 2020/02/14
 *@copyright rainbow
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


}
