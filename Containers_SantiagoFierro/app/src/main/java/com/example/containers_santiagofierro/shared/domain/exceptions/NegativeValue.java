package com.example.containers_santiagofierro.shared.domain.exceptions;

/**
 * If we allow data entry for the user, we have an exception prepared in case he tries
 * to enter a salary or a negative price.
 */
public final class NegativeValue extends Exception{
    public NegativeValue(String value, String className) {
        super("The value " + value + " of " + className + " cannot Negative!!");
    }
}
