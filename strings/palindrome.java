//two types of questions can be framed based on the concept of palindrome i.e.;
//1) given a string find out whether the characters of a string can be rearranged to form a palindrome and
//2) given a string check whether it's a palindrome or not

package strings;

import java.util.*;

public class palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!m.containsKey(s.charAt(i))) {
                m.put(s.charAt(i), 1);
            } else {
                m.put(s.charAt(i), m.get(s.charAt(i)) + 1);
            }
        }
        int count = 0;
        for (Map.Entry<Character, Integer> i : m.entrySet()) {
            if (i.getValue() == 1 && count < 2) {
                // System.out.println("not a palindrome");
                count++;
            } else if (count > 1) {
                System.out.println("not a palindrome");
                break;
            }
        }

        if (count > 1) {
            System.out.println("not a palindrome");
        } else {
            System.out.println("palindrome");
        }

    }
}
