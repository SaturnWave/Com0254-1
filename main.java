package Assigment;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList singlyLinkedList = new LinkedList();
        DoublyLinkedList<Character> doublyLinkedList = new DoublyLinkedList<>();
        CircularLinkedList circularLinkedList = new CircularLinkedList();

        int choice;
        do {
            System.out.println("1 - SingleLinkedList");
            System.out.println("2 - DoubleLinkedList");
            System.out.println("3 - CircularLinkedList");
            System.out.println("0 - Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    singleLinkedListMenu(singlyLinkedList, scanner);
                    break;
                case 2:
                    doubleLinkedListMenu(doublyLinkedList, scanner);
                    break;
                case 3:
                    circularLinkedListMenu(circularLinkedList, scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 0);
    }

    private static void singleLinkedListMenu(LinkedList list, Scanner scanner) {
        int choice;
        do {
            System.out.println("1 - View the list");
            System.out.println("2 - Add Element From the Beginning");
            System.out.println("3 - Add Element to the End");
            System.out.println("4 - Swap Nodes");
            System.out.println("5 - Return");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    list.display();
                    break;
                case 2:
                    System.out.print("Enter element to add: ");
                    int elementBegin = scanner.nextInt();
                    list.insertAtBeginning(elementBegin);
                    break;
                case 3:
                    System.out.print("Enter element to add: ");
                    int elementEnd = scanner.nextInt();
                    list.insertAtEnd(elementEnd);
                    break;
                case 4:
                    System.out.print("Enter the position of the first node to swap: ");
                    int pos1 = scanner.nextInt();
                    System.out.print("Enter the position of the second node to swap: ");
                    int pos2 = scanner.nextInt();
                    list.swapNodes(pos1, pos2);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 5);
    }

    private static void doubleLinkedListMenu(DoublyLinkedList<Character> list, Scanner scanner) {
        int choice;
        do {
            System.out.println("1 - View the List");
            System.out.println("2 - Concatenate with Sample List");
            System.out.println("3 - Return");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    list.display();
                    break;
                case 2:
                    // Create a sample list for demonstration
                    DoublyLinkedList<Character> sampleList = new DoublyLinkedList<>();
                    sampleList.addLast('X');
                    sampleList.addLast('Y');
                    sampleList.addLast('Z');

                    System.out.println("Concatenating with the following sample list:");
                    sampleList.display();

                    // Concatenate list with sampleList
                    list.concatenateLists(sampleList);
                    System.out.println("List after concatenation:");
                    list.display();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 3);
    }

    private static void circularLinkedListMenu(CircularLinkedList list, Scanner scanner) {
        int choice;
        do {
            System.out.println("1 - View the List");
            System.out.println("2 - Clone");
            System.out.println("3 - Return");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    list.display();
                    break;
                case 2:
                    CircularLinkedList clonedList = list.clone();
                    System.out.println("Cloned List:");
                    clonedList.display();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 3);
    }
}