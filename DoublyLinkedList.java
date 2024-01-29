package Assigment;

public class DoublyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    // Method to concatenate two doubly linked lists L and M into L'
    public void concatenateLists(DoublyLinkedList<E> M) {
        if (this.isEmpty()) {
            this.header = M.header; // L is empty, so L' is just M
            this.trailer = M.trailer;
            this.size = M.size;
        } else if (!M.isEmpty()) {
            // Connect the end of L to the beginning of M
            Node<E> lastNodeOfL = this.trailer.getPrev();
            Node<E> firstNodeOfM = M.header.getNext();

            lastNodeOfL.setNext(firstNodeOfM);
            firstNodeOfM.setPrev(lastNodeOfL);

            // Update L's trailer to be M's trailer
            this.trailer = M.trailer;
            this.size += M.size;

            // Disconnect M's header from its first node
            M.header.setNext(M.trailer);
            M.trailer.setPrev(M.header);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        Node<E> currentNode = header.getNext();
        while (currentNode != trailer) {
            System.out.print(currentNode.getElement() + " ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Character> L = new DoublyLinkedList<>();
        DoublyLinkedList<Character> M = new DoublyLinkedList<>();

        // Adding some elements to L and M
        L.addLast('A');
        L.addLast('B');
        L.addLast('C');
        M.addLast('D');
        M.addLast('E');
        M.addLast('F');

        System.out.println("List L before concatenation:");
        L.display();

        System.out.println("List M before concatenation:");
        M.display();

        // Concatenate L and M into L
        L.concatenateLists(M);

        System.out.println("List L after concatenation:");
        L.display();
    }
}
