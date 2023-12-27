package bst;
import java.util.*;
import java.io.*;
static class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        data = data;
        left = null;
        right = null;
    }
}
public class creation {
    public static Node buildTree(String s){

        // if the length of the string is 0 or the first node of the tree is null then return null
        if(s.length() == 0 || s.charAt(0) == 'N'){
            return null;
        }
        String[] ip = s.split(" ");
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(Integer.parseInt(ip[0]));
        q.add(root);
        int i=1;
        while(!q.isEmpty() && i<ip.length){
            Node currNode = q.peek();
            q.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")){
                currNode.left = new Node(Integer.parseInt(currVal));
                q.add(currNode.left);
            }
            i++;
            if(i>ip.length){
                break;
            }
            currVal = ip[i];
            if(!currVal.equals("N")){
            currNode.right = new Node(Integer.parseInt(currVal));
            q.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Node root = buildTree(s);
    }
}
