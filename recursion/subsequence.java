// A subsequence maintain a relative order of the string although it may not be contigous. For a sequence of size n, we 

package recursion;
import java.util.*;
public class subsequence {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        solve(s,"");
    }

    public static void solve(String input, String output){

        // Base condition is to stop the recursion 
        // If the string has no characters or elements in it then we print the output string
        if(input.length() == 0){
            System.out.println(output);
            return;
        }

        // In this solution we have two choices i.e.; to choose the character or to leave the character
        solve(input.substring(1),output+input.charAt(0) );
        solve(input.substring(1), output);
    }
}

// the logic of the problem is to 