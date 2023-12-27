package stacks;

import java.util.*;

public class nextgreatest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int[] arr = new int[n];
	    for(int i=0;i<n;i++){
	        arr[i] = sc.nextInt();
	    }
	    Stack<Integer> s = new Stack<Integer>();
	    ArrayList<Integer> ans = new ArrayList<>();
	    for(int i=n-1;i>=0;--i){
	        
	        // If the size of the stack is zero then add -1 to the ans list as we are accessing the first element
	        // which does not have any greater element after it and add the current element to the stack
	        if(s.size() == 0){
	            ans.add(-1);
	        }

            // If the stack is not empty and the current element is less than the top element of the stack
            // then add the top element of the stack to the list
	        else if(s.size()>0 && s.peek()>arr[i]){
	            ans.add(s.peek());
	        }

            // If the stack is not empty and the current element if greater or equals to the top element of the 
            // stack then remove the elements from the stack until the top element is greater then the current 
            // element or stack becomes empty. If a greater element is found add it to the list or if the stack
            // becomes empty then add -1 to the list and add the current element to the stack.
	        else if(s.size()>0 && s.peek()<=arr[i]){
	            while(s.size()>0 && s.peek()<=arr[i]){
	                s.pop();
	            }
	            if(s.size()<1){
	                ans.add(-1);
	            }
	            else{
	                ans.add(s.peek());
	            }
	        }
	        s.push(arr[i]);
	    }
	    Collections.reverse(ans);
	        System.out.println(ans);
	}
}
