package collections;

import exceptions.IndexLargerListSizeException;

public class LinkedList<T> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    private static class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        Node<T> current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        size++;
    }

    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexLargerListSizeException();
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        int i = 0;

        while (i < index - 1) {
            current = current.next;
            i++;
        }

        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexLargerListSizeException();
        }

        Node<T> current = head;
        int i = 0;

        while (i < index) {
            current = current.next;
            i++;
        }

        return current.data;
    }

    public void removeFirst() {
        if (head == null) {
            return;
        }

        head = head.next;
        size--;
    }

    public void removeLast() {
        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            size--;
            return;
        }

        Node<T> current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
        size--;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexLargerListSizeException();
        }

        if (index == 0) {
            removeFirst();
            return;
        }

        Node<T> current = head;
        int i = 0;

        while (i < index - 1) {
            current = current.next;
            i++;
        }

        current.next = current.next.next;
        size--;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}