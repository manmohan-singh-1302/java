package graph;
import java.util.*;
public class dijkstra {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e =sc.nextInt();
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<ArrayList<Integer>>());
        }
        for(int i=0;i<e;i++){
            int s = sc.nextInt();
            int d = sc.nextInt();
            int w = sc.nextInt();
            ArrayList<Integer> t1 = new ArrayList<>();
            ArrayList<Integer> t2 = new ArrayList<>();
            t1.add(d);
            t1.add(w);
            t2.add(s);
            t2.add(w);
            adj.get(s).add(t1);
            adj.get(v).add(t2);
        }

        System.out.println("enter the starting vertex:");
        int s = sc.nextInt();
        
    }
}
