import java.util.ListIterator;

public class TwoWayLinkedList<E> implements MyList<E> {
    private Node<E> head, tail;
    private int size = 0;

    public TwoWayLinkedList() {
    }

    public TwoWayLinkedList(E[] objects) {
        for (E object : objects)
            add(object);
    }

    public E getFirst() {
        if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }

    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        if (head != null) {
            head.previous = newNode;
        }
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(E e) {
        if (tail == null) {
            addFirst(e);
        } else {
            Node<E> newNode = new Node<>(e);
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            size++;
        }
    }

    @Override
    public void add(int index, E e) {
    }

    public E removeFirst() {
        if (size == 0) {
            return null;
        } else {
            E temp = head.element;
            head = head.next;
            if (head != null) {
                head.previous = null;
            } else {
                tail = null;
            }
            size--;
            return temp;
        }
    }

    public E removeLast() {
    }

    @Override
    public E remove(int index) {
    }

    @Override
    public String toString() {
    }

    @Override
    public void clear() {
        size = 0;
        head = tail = null;
    }

    @Override
    public boolean contains(Object e) {
    }

    @Override
    public E get(int index) {
    }

    @Override
    public int indexOf(Object e) {
    }

    @Override
    public int lastIndexOf(E e) {
    }

    @Override
    public E set(int index, E e) {
    }

    @Override
    public java.util.Iterator<E> iterator() {
    }

    @Override
    public ListIterator<E> listIterator() {
        return new LinkedListIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E e) {
            element = e;
        }
    }

    private class LinkedListIterator implements ListIterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }
    }
}
