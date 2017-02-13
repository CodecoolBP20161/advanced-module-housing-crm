package com.codecool.hccrm.error;

/**
 * Created by dorasztanko on 2017.02.13..
 */
public class CompanyAlreadyExistsException extends Exception {
    public CompanyAlreadyExistsException(String message) {
        super(message);
    }
}
