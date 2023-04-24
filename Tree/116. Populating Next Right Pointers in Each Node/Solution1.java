import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public Node connect(Node root) {
        Queue<Node> nodes = new LinkedList<>();
        Queue<Node> newNodes = new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()){
            Node n = nodes.poll();
            if(n == null)
                continue;
            
            if(n.left != null)
                newNodes.add(n.left);
            if(n.right != null)
                newNodes.add(n.right);
            
            Node right = nodes.peek();
            n.next = right;
            
            if(nodes.isEmpty()){
                nodes = newNodes;
                newNodes = new LinkedList<>();
            }
        }
        return root;
    }
    
}


// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};