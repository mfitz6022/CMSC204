

import java.util.ListIterator;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
    private Comparator<T> comparator;

    public SortedDoubleLinkedList(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void add(T data) {
        Node<T> currentNode = head;
        Node<T> temp = new Node<T>(data);

        if (head == null) {
            head = temp;
            tail = temp;
            size++;
            return;
        }

        if (head.equals(tail)) {
            if (compareHelper(currentNode.getData(), data) < 0) {
                tail = temp;
                head.setNext(tail);
                tail.setPrevious(head);
                size++;
                return;
            } else {
                head = temp;
                head.setNext(tail);
                tail.setPrevious(head);
                size++;
                return;
            }
        }

        if (compareHelper(head.getData(), data) >= 0) {
            temp.setNext(head);
            head.setPrevious(temp);
            head = temp;
            size++;
            return;
        }

        if (compareHelper(tail.getData(), data) <= 0) {
            temp.setPrevious(tail);
            tail.setNext(temp);
            tail = temp;
            size++;
            return;
        }

        while(currentNode.getNext() != null) {
            if (compareHelper(currentNode.getData(), data) < 0 && compareHelper(currentNode.getNext().getData(), data) >= 0) {
                temp.setNext(currentNode.getNext());
                temp.setPrevious(currentNode);
                currentNode.setNext(temp);
                temp.getNext().setPrevious(temp);
                size++;
                return;
            }

            currentNode = currentNode.getNext();
        }
    }

    public int compareHelper(T current, T next) {
        return comparator.compare(current, next);
    }


    @Override
    public Node<T> remove(T targetData, Comparator<T> comparator) {
        return super.remove(targetData, comparator);
    }

    @Override
    public void addToFront(T args0) {
        throw new UnsupportedOperationException(E_MESSAGE);
    }

    @Override
    public void addToEnd(T args0) { throw new UnsupportedOperationException(E_MESSAGE); }

    @Override
    public ListIterator<T> iterator() {
        return super.iterator();
    }
}
