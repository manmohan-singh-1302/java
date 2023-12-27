package graph;

import java.util.*;

public class graph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        // the graph is represented using the adjacency matrix
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < e; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            adj.get(n).add(m);
            adj.get(m).add(n);
        }

        ArrayList<ArrayList<Integer>> ans = print(v, adj);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size() - 1; j++) {
                System.out.print(ans.get(i).get(j) + "-->");
            }
            System.out.print(ans.get(i).get(ans.get(i).size() - 1));
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> print(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < v; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                temp.add(adj.get(i).get(j));
            }
            ans.add(temp);
        }
        return ans;
    }
}
