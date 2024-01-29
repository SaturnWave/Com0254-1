package Assigment;

public class LinkedList {
    private Node head;
    private Node tail;

    // Constructor
    public LinkedList() {
        this.head = null;
        this.tail = null;

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            this.insertAtEnd((int) ch); // Initialize with alphabet
        }
    }

    // Inner class for Node
    private static class Node {
        private int data;
        private Node next;

        // Constructor for Node
        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        // Getters and setters for Node
        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    // Method to insert a node at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    // Method to insert a node at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    // Method to swap two nodes based on their positions
    public void swapNodes(int position1, int position2) {
        if (position1 == position2) return; // No need to swap if positions are the same

        Node node1 = null, node2 = null;
        Node current = head;

        int index = 0;
        while (current != null) {
            if (index == position1) node1 = current;
            if (index == position2) node2 = current;
            current = current.getNext();
            index++;
        }

        if (node1 == null || node2 == null) return; // One or both positions are invalid

        // Find previous nodes of node1 and node2
        Node prev1 = null, prev2 = null, curr = head;
        while (curr != null && (prev1 == null || prev2 == null)) {
            if (curr.getNext() == node1) prev1 = curr;
            if (curr.getNext() == node2) prev2 = curr;
            curr = curr.getNext();
        }

        // Adjust previous nodes' next pointers
        if (prev1 != null) prev1.setNext(node2);
        else head = node2;

        if (prev2 != null) prev2.setNext(node1);
        else head = node1;

        // Swap next pointers of node1 and node2
        Node temp = node1.getNext();
        node1.setNext(node2.getNext());
        node2.setNext(temp);

        // Update tail if necessary
        if (tail == node1) tail = node2;
        else if (tail == node2) tail = node1;
    }

    // Method to display the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print((char)current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
