package com.slloww.lgpd.services.exceptions;

public class ErrorGeneratingToken extends RuntimeException {

    public ErrorGeneratingToken() {
        super("Error while genereting token");
    }

}