package com.example.assignment_2;

import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T> {
    private MyLinkedList<T> stack = new MyLinkedList<T>();
    private int currentSize = 0;
    private int maxSize = 2147483647;

    public MyStack() {}

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public boolean push(T item) throws StackOverflowException{
        try {
            if (isFull())
                throw new StackOverflowException();

            currentSize++;
            return stack.addFirst(item);
        } catch (StackOverflowException e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public String toString() { return stack.toString(); }
    public String toString(String delimiter) {
        return stack.toString(delimiter);
    }

    public void fill(ArrayList<T> list) {
        if (list.size() + currentSize <= maxSize) {
            currentSize += list.size();
            stack.addAll(list);
        }
    }

    public T pop() throws StackUnderflowException{
        try {
            if (isEmpty())
                throw new StackUnderflowException();

            currentSize--;
            return stack.removeFirst();
        } catch (StackUnderflowException e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    public T top() {
        if  (isEmpty())
            return null;

        return stack.getHead();
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public int size() {
        return currentSize;
    }
}
