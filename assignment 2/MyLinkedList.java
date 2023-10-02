package com.example.assignment_2;

import java.util.ArrayList;

public class MyLinkedList<T> {
    private int numberOfNodes = 0;
    private ListNode<T> head = new ListNode<T>();
    private ListNode<T> tail = new ListNode<T>();

    public MyLinkedList() {}
    public boolean addFirst(T value) {
        ListNode<T> temp = new ListNode<T>(value);
        if (head.getValue() == null) {
            head = temp;
            tail = temp;
        } else {
            temp.setNext(head);
            head.setPrev(temp);
            head = temp;
        }

        numberOfNodes++;
        return true;
    }

    public boolean addLast(T value) {
        ListNode<T> temp = new ListNode<T>(value);
        if (tail.getValue() == null) {
            head = temp;
            tail = temp;
        } else {
            temp.setPrev(tail);
            tail.setNext(temp);
            tail = temp;
        }

        numberOfNodes++;
        return true;
    }

    public T removeFirst() {
        if (head.getValue() == null)
            return null;

        if (head.equals(tail)) {
            T temp = head.getValue();
            tail.setNode(null, null, null);
            head.setNode(null, null, null);
            return temp;
        }

        ListNode<T> temp = new ListNode<T>(head);
        head = head.getNext();
        head.setPrev(null);
        temp.setNext(null);

        numberOfNodes--;
        return temp.getValue();
    }

    public T removeLast() {
        if (tail.getValue() == null)
            return null;

        if (tail.equals(head)) {
            T temp = tail.getValue();
            tail.setNode(null, null, null);
            head.setNode(null, null, null);
            return temp;
        }

        ListNode<T> temp = new ListNode<T>(tail);
        tail = tail.getPrev();
        tail.setNext(null);
        temp.setPrev(null);

        numberOfNodes--;
        return temp.getValue();
    }

    public void addAll(ArrayList<T> list) {
        for (T item : list) {
            addFirst(item);
        }
    }

    public T getHead() {
        return head.getValue();
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        ListNode<T> currentNode = head;

        while(currentNode != null) {
            result.append(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        result.reverse();
        return  result.toString();
    }

    public String toString(String delimiter) {
        StringBuilder result = new StringBuilder();
        ListNode<T> currentNode = new ListNode<T>(head);

        while(currentNode.getValue() != null) {
            result.append(currentNode.getValue());

            if (currentNode.getNext() != null)
                result.append(delimiter);

            currentNode = currentNode.getNext();
        }

        result.reverse();
        return  result.toString();
    }
    public boolean isEmpty() {
        return numberOfNodes == 0;
    }

}
