package Assigment;
import java.util.Scanner;


public class CircularLinkedList {
    private COMP254003CLLNode head;
    private COMP254003CLLNode tail;
    private int size;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        for (int i = 1; i <= 8; i++) {
            this.insertAtEnd(Integer.toString(i));
        }
   
    }

    public void insertAtBeginning(String data) {
        COMP254003CLLNode newNode = new COMP254003CLLNode(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            this.tail.setNext(head);
        } else {
            newNode.setNext(head);
            this.head = newNode;
            this.tail.setNext(head);
        }
        this.size++;
    }

    public void insertAtEnd(String data) {
        COMP254003CLLNode newNode = new COMP254003CLLNode(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            this.tail.setNext(head);
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
            this.tail.setNext(head);
        }
        this.size++;
    }

    public void insertAtPosition(String data, int position) {
        COMP254003CLLNode newNode = new COMP254003CLLNode(data);
        if (this.head == null || position <= 0) {
            insertAtBeginning(data);
        } else {
            COMP254003CLLNode current = this.head;
            for (int i = 1; i < position - 1 && current != this.tail; i++) {
                current = current.getNext();
            }
            if (current != tail) {
                newNode.setNext(current.getNext());
                current.setNext(newNode);
            } else {
                insertAtEnd(data);
            }
        }
        this.size++;
    }

    public void deleteAtBeginning() {
        if (this.head == null) {
            System.out.println("List is empty");
        } else {
            this.head = this.head.getNext();
            this.tail.setNext(this.head);
            this.size--;
        }
    }

    public void deleteAtEnd() {
        if (this.head == null) {
            System.out.println("List is empty");
        } else {
            COMP254003CLLNode current = this.head;
            while (current.getNext() != this.tail) {
                current = current.getNext();
            }
            this.tail = current;
            this.tail.setNext(this.head);
            size--;
        }
    }

    public void deleteAtPosition(int position) {
        if (this.head == null) {
            System.out.println("List is empty");
        } else {
            COMP254003CLLNode current = this.head;
            for (int i = 1; i < position - 1 && current != this.tail; i++) {
                current = current.getNext();
            }
            if (current != this.tail) {
                current.setNext(current.getNext().getNext());
            } else {
                deleteAtEnd();
            }
            size--;
        }
    }

    public void display() {
        if (this.head == null) {
            System.out.println("List is empty");
        } else {
            COMP254003CLLNode current = this.head;
            System.out.print(this.size + " ");
            do {
                System.out.print(current.getData() + " ");
                current = current.getNext();
            } while (current != this.head);
            System.out.println();
        }
    }

    public CircularLinkedList clone() {
        CircularLinkedList cloneList = new CircularLinkedList();
        if (this.head == null) {
            return cloneList;
        }

        COMP254003CLLNode current = this.head;
        do {
            cloneList.insertAtEnd(current.getData());
            current = current.getNext();
        } while (current != this.head);

        return cloneList;
    }

    public static void main(String[] args) {
        CircularLinkedList originalList = new CircularLinkedList();
    
        System.out.println("Original list:");
        originalList.display();
    
        CircularLinkedList clonedList = originalList.clone();
    
        System.out.println("Cloned list:");
        clonedList.display();
    }
    

    // Nested Node class
    private static class COMP254003CLLNode {
        private String data;
        private COMP254003CLLNode next;

        public COMP254003CLLNode(String data) {
            this.data = data;
            this.next = null;
        }

        // Getters and setters
        public String getData() {
            return data;
        }

        public COMP254003CLLNode getNext() {
            return next;
        }

        public void setNext(COMP254003CLLNode next) {
            this.next = next;
        }
    }
}