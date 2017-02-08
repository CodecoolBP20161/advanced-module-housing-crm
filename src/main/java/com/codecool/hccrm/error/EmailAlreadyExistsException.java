package com.codecool.hccrm.error;

/**
 * Created by prezi on 2017. 02. 07..
 */
public class EmailAlreadyExistsException extends Exception {
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
