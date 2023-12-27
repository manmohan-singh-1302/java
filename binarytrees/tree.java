package binarytrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import linkedlists.linkedlist;

public class tree {
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static Node buildTree(String s) {
        if (s.length() == 0 || s.charAt(0) == 'N') {
            return null;
        }

        String ip[] = s.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (q.size() > 0 && i < ip.length) {
            Node currNode = q.peek();
            q.remove();
            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                q.add(currNode.left);
            }
            i++;
            if (i > ip.length) {
                break;
            }
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                q.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Node root = buildTree(s);
    }
}
