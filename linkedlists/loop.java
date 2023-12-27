import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class loop {
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
        System.out.println("enter the position where you want to create the loop:");
        int pos = sc.nextInt();
        makeLoop(head, pos, n);

        Node ans = check(head);
        if (ans == null) {
            System.out.println("there is no loop in the linked list");
        } else {
            System.out.println("the loop is at the node:" + ans.data);
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

    static Node makeLoop(Node head, int pos, int n) {

        // Case - 1: if the position given by the user is bigger than the size of the linked list then we cannot create a loop return head
        if (pos > n) {
            return head;
        }
        Node temp = head;
        int count = 1;

        // Traverse the loop until the loop point is found
        while (count < pos) {
            temp = temp.next;
            count++;
        }

        // Store this point as this will be our insertion point of the loop
        Node backup = temp;

        // Now iterate till the last node
        while (temp.next != null) {
            temp = temp.next;
        }

        // Join the last node to the backup node we stored
        temp.next = backup;
        return head;
    }

    // Floyd's Cycle Detection or Hare and Tortoise technique

    // Use two pointer fast and slow and move the fast pointer by two nodes and slow
    // pointer by one node until they meet
    static Node check(Node head) {

        Node fast = head.next;
        Node slow = head;
        while (fast != slow) {

            // Case - 1 : If the first node or the next node of first node is null then
            // there is no loop and return null
            if (fast == null || fast.next == null) {
                return null;
            }

            // Increment the fast pointer by two nodes and slow pointer by one node
            fast = fast.next.next;
            slow = slow.next;
        }

        // If both the pointers are at different nodes then there is no loop and return
        // null
        if (slow != fast) {
            return null;
        }

        // this prints the starting node of the loop
        slow = fast;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}