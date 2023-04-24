import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public Node cloneGraph(Node root) {
        if(root == null)
            return null;
        Node[] nodes = new Node[101];
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(nodes[node.val] == null)
                nodes[node.val] = new Node(node.val, new ArrayList<>());
            else{
                nodes[node.val].val = node.val;
                nodes[node.val].neighbors = new ArrayList<>();
            }
            for(Node ogNeighbour: node.neighbors){
                if(nodes[ogNeighbour.val] == null)
                    nodes[ogNeighbour.val] = new Node(-1, new ArrayList<>());
                if(nodes[ogNeighbour.val].val == -1)
                    queue.add(ogNeighbour);
                nodes[node.val].neighbors.add(nodes[ogNeighbour.val]);
            }
        }
        return nodes[root.val];
    }
}


// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}