package com.example.assignment_2;

public class StackUnderflowException extends Exception {
    StackUnderflowException() {
        super("Error: Stack Underflow. The stack is empty. There are no elements to remove");
    }
}
