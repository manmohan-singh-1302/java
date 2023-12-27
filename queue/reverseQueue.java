package queue;
import java.util.*;
public class reverseQueue {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Queue<Integer> q = new LinkedList<Integer>();
    for(int i=0;i<n;i++){
        q.add(sc.nextInt());
    }
    Stack<Integer> s = new Stack<>();
    while(!q.isEmpty()){
        s.push(q.peek());
        q.remove();
    }
    while(!s.isEmpty()){
        q.add(s.peek());
        s.pop();
    }
    while(!q.isEmpty()){
        System.out.println(q.poll());
    }
}
}