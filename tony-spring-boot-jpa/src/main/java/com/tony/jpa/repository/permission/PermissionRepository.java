package com.tony.jpa.repository.permission;

import com.tony.jpa.entity.permission.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author tony
 * @description PermissionRepository
 * @copyright rainbow
 * @date 2020/03/04
 */
@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, Integer> {
}
