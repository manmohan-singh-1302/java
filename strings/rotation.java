package strings;
import java.util.*;

public class rotation {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String s1 = sc.nextLine();
    String s2 = sc.nextLine();
   if (s1.length() != s2.length()) {
    System.out.println("not rotation");
} else if (s1.isEmpty() && s2.isEmpty()) {
    System.out.println("rotation");
} else {
    String temp = s1.concat(s1);
    if(temp.contains(s2)){
        System.out.println("rotation");
    } else {
        System.out.println("not rotation");
    }
}
}
}



// another sliding window approach to solve this problem


