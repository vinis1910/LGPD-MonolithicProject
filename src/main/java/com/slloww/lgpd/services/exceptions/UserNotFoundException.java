package com.slloww.lgpd.services.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("Username already exists, please, enter another Username");
    }
}
