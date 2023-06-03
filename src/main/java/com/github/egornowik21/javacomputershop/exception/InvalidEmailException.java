package com.github.egornowik21.javacomputershop.exception;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(String s) {
        super(s);
    }
}
