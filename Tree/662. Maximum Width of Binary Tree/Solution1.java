import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> children = new LinkedList<TreeNode>();
        children.add(root);
        boolean allChildrenNull = false;
        int maxWidth = 0;
        // int level = 0;
        while(!allChildrenNull){
            allChildrenNull = true;
            Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
            int width = 0;
            for(TreeNode node: children){
                if(node == null){
                    width++;
                    continue;
                }else{
                    if(width > maxWidth)
                        maxWidth = width;
                    width = 0;
                    nextLevel.add(node.left);
                    nextLevel.add(node.right);
                    if(node.right != null || node.left != null)
                        allChildrenNull = false;
                }
            }
            // level++;
            children = nextLevel;
        }
        return maxWidth;     
    }
}


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
