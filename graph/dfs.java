package graph;

import java.util.*;

public class dfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        // We add any empty adjacecy list for all the vertices to represent the adjacency list of each vertices
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < e; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            adj.get(n).add(m);
            adj.get(m).add(n);
        }
        display(adj);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans = dfs(adj, v);
        System.out.println(ans);
    }

    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean visited[] = new boolean[v];
        int s = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        helper(s, visited, ans, adj);
        return ans;
    }

    static void helper(int s, boolean[] visited, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj) {
        visited[s] = true;
        ans.add(s);
        for (int i = 0; i < adj.get(s).size(); i++) {
            if (!visited[adj.get(s).get(i)]) {
                helper(adj.get(s).get(i), visited, ans, adj);
            }
        }
    }

    static void display(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print("-->" + adj.get(i).get(j));
            }
            System.out.println();
        }
    }
}
