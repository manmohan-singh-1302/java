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

public class insertionAndDeletion{
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
        System.out.println(
                "1) insertion at the beginnnig 2) insertion after a node 3) insertion at the end 4)Delete at front 5) Delete at position 6) Delete at the end");
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                int val = sc.nextInt();
                head = push(head, val);
                break;
            case 2:
                val = sc.nextInt();
                int pos = sc.nextInt();
                head = append(head, pos, val);
                break;
            case 3:
                val = sc.nextInt();
                head = appendLast(head, val);
                break;
            case 4:
                head = remove(head);
                break;
            case 5:
                pos = sc.nextInt();
                head = removeAfter(head, pos);
                break;
            case 6:
                head = removeAtEnd(head);
        }

        display(head);
    }

    static Node removeAtEnd(Node head) {
        Node temp = head;

        // Traverse to the last second node of the linked list
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    static Node removeAfter(Node head, int pos) {
        if (pos == 1) {
            remove(head);
        }
        Node temp = head;
        
        for (int i = 2; i < pos; i++) {
            if (temp.next != null) {
                temp = temp.next;
            }
        }
        temp.next = temp.next.next;
        return head;
    }

    static Node remove(Node head) {
        head = head.next;
        return head;
    }

    static Node appendLast(Node head, int val) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val);
        return head;
    }

    static Node append(Node head, int prev, int val) {
        Node newnode = new Node(val);
        int count = 1;
        Node temp = head;
        while (temp != null && count < prev) {
            temp = temp.next;
            count++;
        }
        newnode.next = temp.next;
        temp.next = newnode;
        return head;
    }

    static Node push(Node head, int val) {
        Node newnode = new Node(val);
        if (head == null) {
            head = newnode;
            return head;
        }
        newnode.next = head;
        head = newnode;
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
