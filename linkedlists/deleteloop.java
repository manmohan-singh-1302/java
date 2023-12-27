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

public class deleteloop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null;
        Node tail = head;
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            if (head == null) {
                Node newnode = new Node(data);
                head = newnode;
                tail = head;
            } else {
                Node newnode = new Node(data);
                tail.next = newnode;
                tail = newnode;
            }
        }
        display(head);
        int pos = sc.nextInt();
        makeLoop(head, pos);
        if (check(head)) {
            System.out.println("there is a loop in the linked list");
            if (removeLoop(head, n)) {
                System.out.println("linked list after removing the loop is:");
                display(head);
            }
        } else {
            System.out.println("there is no loop in the linked list");
        }
        sc.close();
    }

    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    static boolean removeLoop(Node head, int n) {
        Node fast = head;
        Node slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = head;
        fast = head;
        for (int i = 0; i < n - 1; i++) {
            fast = fast.next;
        }

        while (slow != fast.next) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = null;
        return true;
    }

    static boolean check(Node head) {
        Node fast = head.next;
        Node slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        if (slow != fast) {
            return false;
        }
        return true;
    }

    static Node makeLoop(Node head, int pos) {
        Node temp = head;
        int count = 1;
        while (count < pos) {
            temp = temp.next;
            count++;
        }
        Node backup = temp;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = backup;
        return head;
    }
}
