package com.example.assignment_2;
import java.util.ArrayList;
public class MyQueue<T> implements QueueInterface<T>{
    private MyLinkedList<T> queue = new MyLinkedList<T>();
    private int maxSize = 2147483647;
    private int currentSize = 0;


    public MyQueue() {}
    public MyQueue(int max_size) {
        this.maxSize = max_size;
    }

    public boolean enqueue(T value) throws QueueOverflowException{
        try {
            if (isFull())
                throw new QueueOverflowException();

            currentSize++;
            queue.addFirst(value);
            return true;
        } catch (QueueOverflowException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public T dequeue() throws QueueUnderflowException {
        try {
            if (isEmpty())
                throw new QueueUnderflowException();

            currentSize--;
            return queue.removeLast();
        } catch(QueueUnderflowException e) {
            System.out.println(e.getMessage());
            return null;
        }
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

    public void fill(ArrayList<T> list) {
        try {
            if (list.size() + currentSize > maxSize)
                throw new QueueUnderflowException();

            currentSize += list.size();
            queue.addAll(list);
        } catch(QueueUnderflowException e) {
            System.out.println(e.getMessage());
        }
    }
    public String toString() {
        return queue.toString();
    }
    public String toString(String delimiter) {
        return queue.toString(delimiter);
    }
}
