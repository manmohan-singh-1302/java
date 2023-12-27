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

public class intersection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of nodes for the first linked list");
        int n1 = sc.nextInt();
        Node head1 = null;
        Node tail1 = head1;
        for (int i = 0; i < n1; i++) {
            Node newnode = new Node(sc.nextInt());
            if (head1 == null) {
                head1 = newnode;
                tail1 = head1;
            } else {
                tail1.next = newnode;
                tail1 = newnode;
            }
        }
        System.out.println("enter the number of nodes for the second linked list");
        int n2 = sc.nextInt();
        Node head2 = null;
        Node tail2 = head2;
        for (int i = 0; i < n2; i++) {
            Node newnode = new Node(sc.nextInt());
            if (head2 == null) {
                head2 = newnode;
                tail2 = head2;
            } else {
                tail2.next = newnode;
                tail2 = newnode;
            }
        }

        Node ans = intersection(head1, head2, n1, n2);

        if (ans != null) {
            System.out.println("the intersection point of the linked lists is:" + ans.data);
        } else {
            System.out.println("linked lists do not intersect each other");
        }

        // display(head1);
        // display(head2);
    }

    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    static Node intersection(Node head1, Node head2, int n1, int n2) {
        // System.out.println(head1.data);
        // System.out.println(head2.data);
        for (; n1 > n2; n1 -= 1) {
            head1 = head1.next;
        }
        for (; n2 > n1; n2 -= 1) {
            head2 = head2.next;
        }
        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        if (head1 != null)
            return head1;
        return null;
    }
}
