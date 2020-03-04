package com.tony.jpa.repository.permission;

import com.tony.jpa.entity.permission.PermissionGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tony
 * @description PermissionGroupRepository
 * @copyright rainbow
 * @date 2020/03/04
 */
public interface PermissionGroupRepository extends JpaRepository<PermissionGroupEntity, Integer> {
}
