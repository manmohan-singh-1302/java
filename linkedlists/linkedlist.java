package linkedlists;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class linkedlist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null;
        Node tail = head;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            //case-1: if the linked list has no nodes then create a newnode and assign the newnode to the head part and link the tail to the head
            if (head == null) {
                Node newnode = new Node(num);
                head = newnode;
                tail = head;
            } 
            
            //case-2: if there is already atleast a node in the linked list then create a newnode and assign the newnode to tail.next
            // after assigning shift the tail to the newnode (As tail should always inidcate the last node of the linked list)
            else {
                Node newnode = new Node(num);
                tail.next = newnode;
                tail = newnode;
            }
        }
        display(head);
    }

    public static void display(Node head) {

        if (head == null) {
            System.out.println("empty");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }
}