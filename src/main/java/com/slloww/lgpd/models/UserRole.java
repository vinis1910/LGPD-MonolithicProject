package com.slloww.lgpd.models;

public enum UserRole {

    ADMIN("ADMIN"),

    USER("USER");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }
}
