package graph;

import java.util.*;

import linkedlists.linkedlist;

public class bfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
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
        display(adj);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans = bfs(adj, v);
        System.out.println(ans);
        sc.close();
    }

    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int v) {
        ArrayList<Integer> ans = new ArrayList<Integer>();

        // a boolean array to keep track of the visited edges
        boolean visited[] = new boolean[v];
        int s = 0;
        visited[s] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        while (q.size() != 0) {
            s = q.poll();
            ans.add(s);

            //create an list iterator for the current node
            Iterator<Integer> i = adj.get(s).listIterator();
            while (i.hasNext()) {
                int temp = i.next();
                if (!visited[temp]) {
                    visited[temp] = true;
                    q.add(temp);
                }
            }
        }
        return ans;
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