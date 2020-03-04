package com.tony.jpa.repository;

import com.tony.jpa.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author tony
 * @describe TenantRepository
 * @copyright rainbow
 * @date 2020/02/14
 */
@Repository
public interface TenantRepository extends JpaRepository<Tenant, Integer> {
}
