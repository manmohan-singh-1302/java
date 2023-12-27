package linkedlists;

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null;
        Node tail = head;
        for (int i = 0; i < n; i++) {
            Node newnode = new Node(sc.nextInt());
            if (head == null) {
                head = newnode;
                tail = head;
            } else {
                tail.next = newnode;
                tail = newnode;
            }
        }

        display(head);

        head = reverse(head);

        System.out.println("linked list after reversing is");

        display(head);
    }

    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    static Node reverse(Node head) {

        // Create a stack to store the nodes
        Stack<Node> s = new Stack<Node>();
        Node temp = head;

        // Push all the nodes from the linked list into the stack except the last node
        while (temp.next != null) {
            s.push(temp);
            temp = temp.next;
        }

        // Assign the temp node to the head it will be the new head of the linked list
        head = temp;

        // Now assign the nodes from the stack until it is empty to the temp.next
        while (!s.empty()) {
            temp.next = s.peek();
            s.pop();
            temp = temp.next;
        }

        // Assign the null value at the end of the linked list
        temp.next = null;
        return head;
    }
}