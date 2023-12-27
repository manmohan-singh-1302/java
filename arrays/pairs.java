import java.util.*;
public class pairs {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }   
        int target = sc.nextInt();
        int count = 0;
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i=0;i<n;i++){

            // if the sum is found in the hashmap then we increment the count value by number of occurance of the elements present
            if(h.containsKey(target - arr[i])){
                count+=h.get(target-arr[i]);
            }

            // if we dont find the targeted sum and the current element is already present in the hashmap then increment the count 
            else if(h.containsKey(arr[i])){
                h.put(arr[i],h.get(arr[i])+1);
            }

            // if the current element is not present in the hashmap then add the element to the hashmap
            else{
                h.put(arr[i],1);
        }
        }
        System.out.println(count);
    }
}
