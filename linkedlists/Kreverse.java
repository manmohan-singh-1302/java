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

public class Kreverse {
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
        int k = sc.nextInt();
        System.out.println("linked list after reversing in the groups:");
        head = reverseK(head, k);
        display(head);
    }

    static Node reverseK(Node head, int k) {
        Stack<Node> s = new Stack<>();
        Node current = head;
        Node prev = null;
        while (current != null) {
            int count = 0;
            while (current != null && count < k) {
                s.push(current);
                current = current.next;
                count++;
            }
            while (!s.empty()) {
                if (prev == null) {
                    prev = s.peek();
                    head = prev;
                    s.pop();
                } else {
                    prev.next = s.peek();
                    prev = prev.next;
                    s.pop();
                }
            }
        }
        prev.next = null;
        return head;
    }

    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
