package slidingwindow;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class longestsubstringWithoutRepetation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine(); // Example input
        int length = lengthOfLongestSubstring(input);
        System.out.println("The length of the longest substring without repeating characters is: " + length);
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int longest = 0, i = 0, j = 0;

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                longest = Math.max(longest, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return longest;
    }    
}
