package com.nc13.board.model.Enum;

public enum UserRole {
    ROLE_USER("ROLE_USER"), ROLE_ADMIN("ROLE_ADMIN");

    private String name;

    private UserRole(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
