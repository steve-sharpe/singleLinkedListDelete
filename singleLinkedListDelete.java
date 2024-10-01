// Author: Steve Sharpe

public class singleLinkedListDelete {
    Node head; // Head of the list

    // Node class representing each element in the list
    class Node {
        int data; // Data of the node
        Node next; // Reference to the next node

        // Constructor to create a new node
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Deleting a node from the list
    public void deleteNode(int key) {
        Node temp = head, prev = null; // Initialize temp and prev

        // If the list is empty
        if (temp == null) {
            System.out.println("The list is empty.");
            return;
        }

        // If head node itself holds the key (deleting from the beginning)
        if (temp != null && temp.data == key) {
            head = temp.next; // Change head
            System.out.println("Node with key " + key + " deleted from the beginning.");
            return;
        }

        // Search for the key to be deleted, keep track of the previous node
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in the list
        if (temp == null) {
            System.out.println("Node with key " + key + " not found.");
            return;
        }

        // If the node to be deleted is the last node (deleting from the end)
        if (temp.next == null) {
            prev.next = null;
            System.out.println("Node with key " + key + " deleted from the end.");
            return;
        }

        // Unlink the node from the list (deleting from anywhere in the list)
        prev.next = temp.next;
        System.out.println("Node with key " + key + " deleted from the middle.");
    }

    // Printing the list
    public void printList() {
        Node tnode = head; // Initialize current node
        while (tnode != null) { // Traverse through the list
            System.out.print(tnode.data + " "); // Print the data
            tnode = tnode.next; // Move to the next node
        }
    }

    public static void main(String[] args) {
        singleLinkedListDelete llist = new singleLinkedListDelete(); // Create a new list
        llist.append(6); // Add 6 at the end
        llist.push(7); // Add 7 at the beginning
        llist.push(1); // Add 1 at the beginning
        llist.append(4); // Add 4 at the end
        llist.insertAfter(llist.head.next, 8); // Add 8 after the second node
        System.out.println("\nCreated Linked list is: ");
        llist.printList(); // Print the list
        llist.deleteNode(1); // Delete node with data 1
        System.out.println("\nLinked List after Deletion of 1: ");
        llist.printList(); // Print the list again
    }

    // Inserting a new node at the beginning of the list
    public void push(int new_data) {
        Node new_node = new Node(new_data); // Create a new node
        new_node.next = head; // Make next of new node as head
        head = new_node; // Move the head to point to the new node
    }

    // Inserting a new node after the given prev_node
    public void insertAfter(Node prev_node, int new_data) {
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node new_node = new Node(new_data); // Create a new node
        new_node.next = prev_node.next; // Make next of new node as next of prev_node
        prev_node.next = new_node; // Make next of prev_node as new_node
    }

    // Inserting a new node at the end of the list
    public void append(int new_data) {
        Node new_node = new Node(new_data); // Create a new node
        if (head == null) { // If the list is empty
            head = new Node(new_data); // Make the new node as head
            return;
        }
        new_node.next = null; // Make next of new node as null
        Node last = head; // Traverse to the last node
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node; // Change the next of last node
    }
}