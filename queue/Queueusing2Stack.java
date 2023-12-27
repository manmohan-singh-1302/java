package queue;

import java.util.*;

class StackQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();


    //always try to remove elements from the first stack and then insert
    void Push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    int Pop() {
        if (s1.isEmpty()) {
            return -1;
        }
        return s1.pop();
    }
}

public class Queueusing2Stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // total number of queries
        int n = sc.nextInt();
        StackQueue s = new StackQueue();
        for (int i = 0; i < n; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int temp = sc.nextInt();
                s.Push(temp);
            } else if (type == 2) {
                System.out.println(s.Pop() + " ");
            }
        }
    }
}