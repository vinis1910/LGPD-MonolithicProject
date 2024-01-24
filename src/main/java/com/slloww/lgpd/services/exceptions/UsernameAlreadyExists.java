package com.slloww.lgpd.services.exceptions;

public class UsernameAlreadyExists extends RuntimeException {

    public UsernameAlreadyExists() {
        super("Username already exists, please, enter another Username");
    }

}
