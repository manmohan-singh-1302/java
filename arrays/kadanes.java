import java.util.*;

public class kadanes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int currSum = 0; // It keeps track of the current contiguous sum 
		int largestSum = 0; // It keeps track of the maximum sum encountered so far
		for (int i = 0; i < n; i++) {
			currSum += arr[i];

			// If current sum becomes less than the currrent element then set the current sum to the current element.
			if (currSum < arr[i]) {
				currSum = arr[i];
			}

			// Update the largest sum 
			largestSum = Math.max(largestSum, currSum);
		}
		System.out.println(largestSum);
		sc.close();
	}
}
