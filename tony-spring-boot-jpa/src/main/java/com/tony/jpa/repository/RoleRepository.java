package com.tony.jpa.repository;

import com.tony.jpa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author tony
 * @describe RoleRepository
 * @copyright rainbow
 * @date 2020/02/14
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {


}
