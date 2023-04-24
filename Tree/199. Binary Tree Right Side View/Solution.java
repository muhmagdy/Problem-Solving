import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        int maxDepth = -1;
        int currDepth = -1;
        HashMap<TreeNode, Integer> level = new HashMap<>();
        TreeNode t = root;
        while(!s.empty() || t != null){
            if(t == null){
                t = s.pop();
                currDepth = level.get(t);
                t = t.left;
                continue;
            }
            currDepth++;
            if(currDepth > maxDepth){
                maxDepth = currDepth;
                rightSide.add(t.val);
            }
            s.push(t);
            level.put(t, currDepth);
            t = t.right;

        }
        return rightSide;
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}