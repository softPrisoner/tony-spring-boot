package com.tony.jpa.repository.permission;

import com.tony.jpa.entity.permission.SystemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * System Repository
 *
 * @author tony
 * @description SystemRepository
 * @copyright rainbow
 * @date 2020/02/14
 */
@Repository
public interface SystemRepository extends JpaRepository<SystemEntity, Integer> {

}
