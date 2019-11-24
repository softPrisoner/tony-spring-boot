package com.rainbow.tony.shiro.chapter12.entity;

import java.io.Serializable;

/**
 * @author tony
 * @describe Role
 * @date 2019-09-13
 */
public class Role implements Serializable {
    private Long id;
    private String role;
    private String decription;
    private Boolean available = Boolean.FALSE;

    public Role() {

    }

    public Role(String role, String description, Boolean available) {
        this.role = role;
        this.decription = description;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
