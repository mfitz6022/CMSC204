package com.example.assignment_2;

public class StackOverflowException extends Exception {
    StackOverflowException() {
        super("Error: Stack Overflow. Maximum stack size exceeded");
    }
}
