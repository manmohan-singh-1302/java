import java.util.*;
public class solve {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s = sc.nextLine();
        String[] input = s.split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<input.length;i++){
            arr.add(Integer.parseInt(input[i]));
        }
        int B = sc.nextInt(); // Example B
        System.out.println("The " + B + "th missing positive integer is: " + findKthPositive(arr, B));
    }

    public static int findKthPositive(ArrayList<Integer> A, int B) {
        int missingCount = 0, lastMissing = 0, current = 1, i = 0;

        while (missingCount < B) {
            if (i < A.size() && A.get(i) == current) {
                i++;
            } else {
                lastMissing = current;
                missingCount++;
            }
            current++;
        }

        return lastMissing;
    }
}