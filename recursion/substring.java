package recursion;
import java.util.*;
public class substring {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        solve(s);
    }
    public static void solve(String s){
        helper(s,"");
    }
    public static void helper(String s, String ans){
        if(s.length() == 0){
            System.out.println(ans);
        }
        helper(s.substring(1),ans+s.charAt(0));
        helper(s.substring(1), ans);
    }
}
