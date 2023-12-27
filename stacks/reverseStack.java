// In order to reverse a stack we need to empty the stack until the last element and insert every element 
// 

package stacks;
import java.util.*;
public class reverseStack {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<n;i++){
            s.push(sc.nextInt());
        }
        reverse(s);
        for(Integer i: s)
        {
            System.out.println(i);
        }
    }

    public static void reverse(Stack<Integer> s){
        if(s.empty()){
            return;
        }
        int temp = s.pop();
        reverse(s);
        insertAtBottom(s, temp);
    }

    public static void insertAtBottom(Stack<Integer> s, int temp){
        if(s.empty()){
            s.push(temp);
            return;
        }
        else{
            int t = s.pop();
            insertAtBottom(s, temp);
            s.push(t);
        }
    }
}
