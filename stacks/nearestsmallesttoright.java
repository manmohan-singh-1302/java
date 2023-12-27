package stacks;
import java.util.*;
public class nearestsmallesttoright {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans = solve(arr,n);
        System.out.println(ans);
    }
    public static ArrayList<Integer> solve(int[] arr, int n){
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=n-1;i>=0;--i){
            if(s.isEmpty()){
                ans.add(-1);
            }
            else if(!s.isEmpty() && s.peek()<arr[i]){
                ans.add(s.peek());
            }
            else{
                while(!s.isEmpty() && s.peek()>=arr[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    ans.add(-1);
                }else{
                    ans.add(s.peek());
                }
            }
            s.push(arr[i]);
        }
        Collections.reverse(ans);
        return ans;
    }
}
