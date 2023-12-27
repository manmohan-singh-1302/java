package stacks;
import java.util.*;
public class paranthesis {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> st = new Stack<>();

        // If the first character of the string itself is a closing bracket then it is not balanced
        if(s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}'){
                System.out.println("not balanced");
            }
        for(int i=0;i<s.length();i++){

            // if the current character is an opening bracket then push it into the stack
            if(s.charAt(i) == '('|| s.charAt(i) == '['||s.charAt(i) == '{'){
                st.push(s.charAt(i));
            }
            else{

                // if the current character is a closing bracket and the top element of the stack is opening bracket then remove the element from the stack
                if(s.charAt(i) == ')' && st.peek() == '(' || s.charAt(i) == ']' && st.peek() == '[' || s.charAt(i) == '}' && st.peek() == '{'){
                    st.pop();
                }

                // break the loop as it is not balanced
                else{
                    break;
                }
            }
        }

        // If the stack is empty then the string is balanced
        if(st.isEmpty()){
            System.out.println("its balanced");
        }

        // If the stack is not empty then the string is not balanced
        else{
            System.out.println("not balanced");
        }
    }
}
