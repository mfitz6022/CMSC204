package com.example.assignment_2;

public class QueueUnderflowException extends Exception {
    QueueUnderflowException() {
        super("Error: Queue Underflow. Queue is already empty");
    }
}
