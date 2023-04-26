import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null)
            return new LinkedList();
        List<List<Integer>> levelOrder = new LinkedList<>();
        List<TreeNode> level = new LinkedList<>();
        List<TreeNode> nextLevel = new LinkedList<>();
        level.add(root);
        levelOrder.add(0, level.stream().map((x) -> x.val).toList());
        while(!level.isEmpty()){
            TreeNode node = level.remove(0);
            if(node.left != null) nextLevel.add(node.left);
            if(node.right != null) nextLevel.add(node.right);
            if(level.isEmpty() && !nextLevel.isEmpty()){
                List<TreeNode> temp = level;
                level = nextLevel;
                nextLevel = temp;
                levelOrder.add(0, level.stream().map((x) -> x.val).toList());
            }
        }
        return levelOrder;
    }
}

// Definition for a binary tree node.
public class TreeNode {
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
