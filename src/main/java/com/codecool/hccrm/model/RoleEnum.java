package com.codecool.hccrm.model;

/**
 * Created by dorasztanko on 2017.02.19..
 */
public enum RoleEnum {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_CEO("ROLE_CEO"),
    ROLE_MANAGER("ROLE_MANAGER");

    private final String role;

    RoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}
