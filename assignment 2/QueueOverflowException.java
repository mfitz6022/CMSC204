package com.example.assignment_2;

public class QueueOverflowException extends Exception {
    public QueueOverflowException() {
        super("Error: Queue Overflow. Maximum queue size exceeded");
    }
}
