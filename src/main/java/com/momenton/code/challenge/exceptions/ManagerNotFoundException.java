package com.momenton.code.challenge.exceptions;

/**
 * Created by Eric Ralhan on 14/01/2017.
 */
public class ManagerNotFoundException extends RuntimeException {

    public ManagerNotFoundException(Integer empId) {
        super("Invalid Manager for employee - " + empId);
    }
}
