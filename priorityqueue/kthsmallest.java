// max heap is used to find the kth smallest number in an unsorted array 

package priorityqueue;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class kthsmallest {

    public static int kthsmallestNumber(int arr[], int n, int k) {
        //while creating the priority queue by default min heap is created 
        //by using the Collections.reverseOrder() we can convert that into maxheap
        PriorityQueue<Integer> h = new PriorityQueue<Integer>(Collections.reverseOrder(null));
        for (int i = 0; i < n; i++) {
            h.add(arr[i]);
            if (h.size() > k) {
                h.remove();
            }
        }
        return h.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int ans = kthsmallestNumber(arr, n, k);
        System.out.println(ans);
    }
}
