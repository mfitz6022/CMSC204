package com.example.assignment_2;

public class ListUnderflowException extends Exception {
    ListUnderflowException() {
        super("Linked List Underflow Exception: The specified Linked List is already empty");
    }
}
