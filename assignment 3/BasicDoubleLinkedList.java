
import java.lang.UnsupportedOperationException;
import java.util.*;

public class BasicDoubleLinkedList<T>  {
    protected Node<T> head;
    protected Node<T> tail;
    protected int size;
    protected final String E_MESSAGE = "Invalid operation for sorted list";

    public BasicDoubleLinkedList() {}

    public void addToEnd(T data) {
        Node<T> temp = new Node<>(data);
        if (head == null) {
            head = temp;
            tail = temp;
            System.out.println("head: " + head.getData() + "/nTail: " + tail.getData());
        } else {
            tail.setNext(temp);
            temp.setPrevious(tail);
            tail = temp;
        }
        size++;
    }

    public void addToFront(T data) {
        Node<T> temp = new Node<>(data);
        if (head == null) {
            head = temp;
            tail = temp;
            System.out.println("head: " + head.getData() + "/nTail: " + tail.getData());
        } else {
            temp.setNext(head);
            head.setPrevious(temp);
            head = temp;
        }
        size++;
    }

    public T getFirst() {
        if (head != null)
            return head.getData();

        return null;
    }

    public T getLast() {
        if (tail != null)
            return tail.getData();

        return null;
    }

    public int getSize() {
        return size;
    }

    public ListIterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }

    public Node remove(T targetData, Comparator<T> comparator) {
        Node<T> currentNode = head;

        if (head == null) {
            return null;
        }

        if (head.equals(tail)) {
            head = null;
            tail = null;
            size--;
            return currentNode;
        }

        if (comparator.compare(head.getData(), targetData) == 0) {
            head = head.getNext();
            head.setPrevious(null);
            size--;
            return currentNode;
        }

        if (comparator.compare(tail.getData(), targetData) == 0) {
            currentNode = tail;
            tail = tail.getPrevious();
            tail.setNext(null);
            size--;
            return currentNode;
        }

        while(currentNode.getNext() != null) {
            if (comparator.compare(currentNode.getData(), targetData) == 0) {
                currentNode.getNext().setPrevious(currentNode.getPrevious());
                currentNode.getPrevious().setNext(currentNode.getNext());
                size--;
                return currentNode;
            }

            currentNode = currentNode.getNext();
        }

        return null;
    }

    public T retrieveFirstElement() {
        if (head == null)
            return null;

        T temp = head.getData();
        head = head.getNext();
        head.setPrevious(null);

        size--;
        return temp;
    }

    public T retrieveLastElement() {
        if (tail == null)
            return null;

        T temp = tail.getData();

        if (head.equals(tail)) {
            head = null;
            tail = null;
            return temp;
        }

        tail = tail.getPrevious();
        tail.setNext(null);

        size--;
        return temp;
    }

    public ArrayList<T> toArrayList() {
        ArrayList<T> list = new ArrayList<>();
        Node<T> currentNode = head;

        if (head == null) {
            return list;
        }

        do {
            list.add(currentNode.getData());
            currentNode = currentNode.getNext();
        } while(currentNode != null);

        return list;
    }

    public class Node<T> {
        private Node<T> previous;
        private T data;
        private Node<T> next;

        public Node() {}

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public Node(T data, Node<T> next, Node<T> previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }

    public class DoubleLinkedListIterator implements ListIterator<T> {
        Node<T> currentNode;

        public DoubleLinkedListIterator() {
            currentNode = head;
        }

        @Override
        public void add(T arg0)  {
            throw new UnsupportedOperationException(E_MESSAGE);
        }

        @Override
        public boolean hasNext() {
            return currentNode.getNext() != null;
        }

        @Override
        public boolean hasPrevious() {
            return currentNode.getPrevious() != null;
        }

        @Override
        public T next() throws NoSuchElementException {
            try {
                if (currentNode.getNext() == null)
                    throw new NoSuchElementException();

                currentNode = currentNode.getNext();
                return currentNode.getData();

            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException(E_MESSAGE);
        }

        @Override
        public T previous() throws NoSuchElementException {
            try {
                if (currentNode.getPrevious() == null)
                    throw new NoSuchElementException();

                currentNode = currentNode.getPrevious();

                return currentNode.getData();
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException(E_MESSAGE);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException(E_MESSAGE);
        }

        @Override
        public void set(T arg0) {
            throw new UnsupportedOperationException(E_MESSAGE);
        }
    }
}
