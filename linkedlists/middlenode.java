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

public class middlenode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null;
        Node tail = head;
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            Node newnode = new Node(data);
            if (head == null) {
                head = newnode;
                tail = head;
            } else {
                tail.next = newnode;
                tail = newnode;
            }
        }
        display(head);
        Node ans = middle(head);
        System.out.println(ans.data);
        sc.close();
    }

    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    static Node middle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}