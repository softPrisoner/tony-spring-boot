package com.tony.jpa.repository.permission;

import com.tony.jpa.entity.permission.RoleGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Role Group Repository
 *
 * @author tony
 * @description RoleGroupRepository
 * @copyright rainbow
 * @date 2020/02/14
 */
@Repository
public interface RoleGroupRepository extends JpaRepository<RoleGroupEntity, Integer> {
}
