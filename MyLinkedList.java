package LinkedList;

import java.util.Arrays;

public class MyLinkedList {
    private Node head;
    private int size;

    public void add(int value) {
        if (head == null) {
            this.head = new Node(value);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
            // [1] --> [2] --> [3] -- [4] ...
        }
        size++;
    }

    public int get(int idx) {
        int currentIdx = 0;
        Node temp = head;
        while (temp != null) {
            if (currentIdx == idx) {
                return temp.getValue();
            } else {
                temp = temp.getNext();
                currentIdx++;
            }
        }
        throw new IllegalArgumentException();
    }

    public void remove(int idx) {
        if (idx == 0) {
            head = head.getNext();
            size--;
            return;
        }
        int currentIdx = 0;
        Node temp = head;
        while (temp != null) {
            if (currentIdx == idx - 1) {
                temp.setNext(temp.getNext().getNext());
                size--;
                return;
            } else {
                temp = temp.getNext();
                currentIdx++;
            }
        }
    }

    public String toString() {
        int[] result = new int[size];
        int index = 0;
        Node temp = head;
        while (temp != null) {
            result[index] = temp.getValue();
            index++;
            temp = temp.getNext();

        }
        return Arrays.toString(result);
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }


        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
