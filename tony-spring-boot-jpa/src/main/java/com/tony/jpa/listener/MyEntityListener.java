package com.tony.jpa.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

/**
 * Jpa entity listener
 *
 * @author tony
 * @describe MyEntityListener
 * @date 2020/02/14
 */
public class MyEntityListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyEntityListener.class);

    /**
     * PrePersist
     *
     * @param entity entity
     */
    @PrePersist
    public void prePersist(Object entity) {
        LOGGER.info("Before save--{}", entity.toString());
    }

    /**
     * PreUpdate
     *
     * @param entity entity
     */
    @PreUpdate
    public void preUpdate(Object entity) {
        LOGGER.info("Before update--{}", entity.toString());
    }

    /**
     * PreRemove
     *
     * @param entity entity
     */
    @PreRemove
    public void preRemove(Object entity) {
        LOGGER.info("Before remove--{}", entity.toString());
    }

    /**
     * PostPersist
     *
     * @param entity entity
     */
    @PostPersist
    public void postPersist(Object entity) {
        LOGGER.info("After Persist--{}", entity.toString());
    }

    /**
     * PostUpdate
     *
     * @param entity entity
     */
    @PostUpdate
    public void postUpdate(Object entity) {
        LOGGER.info("After update--{}", entity.toString());
    }

    /**
     * PostRemove
     *
     * @param entity entity
     */
    @PostRemove
    public void postRemove(Object entity) {
        LOGGER.info("After remove--", entity.toString());
    }
}
