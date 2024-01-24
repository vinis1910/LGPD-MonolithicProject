package com.slloww.lgpd.services.exceptions;

public class EmailAlreadyExists extends RuntimeException {
    public EmailAlreadyExists() {
        super("Email already exists, please, enter another Email");
    }
}

