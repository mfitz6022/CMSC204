package com.example.assignment_2;

import java.util.List;

public class ListNode<T> {
    private T value;
    private ListNode<T> next;
    private ListNode<T> prev;

    public ListNode() {
        this.next = null;
        this.value = null;
        this.prev = null;
    }

    public ListNode(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public ListNode(T value, ListNode<T> next) {
        this.value = value;
        this.next = next;
        this.prev = null;
    }

    public ListNode(T value, ListNode<T> next, ListNode<T> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public ListNode(ListNode<T> listNode) {
        this.value = listNode.getValue();
        this.next = listNode.getNext();
        this.prev = listNode.getPrev();
    }

    public boolean setNode(ListNode<T> node) {
        value = node.value;
        next = node.next;
        prev = node.prev;
        return true;
    }

    public boolean setNode(T value, ListNode<T> next, ListNode<T>  prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
        return true;
    }

    public boolean setValue(T value) {
        this.value = value;
        return true;
    }
    public boolean setNext(ListNode<T> next) {
        this.next = next;
        return true;
    }
    public boolean setPrev(ListNode<T> prev) {
        this.prev = prev;
        return true;
    }
    public ListNode<T> getNext() {
        return next;
    }
    public ListNode<T> getPrev() {
        return prev;
    }
    public T getValue() {
        return value;
    }
}
