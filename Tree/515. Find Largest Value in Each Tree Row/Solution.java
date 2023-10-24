/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> currentRow = new LinkedList<>();
        Queue<TreeNode> nextRow = new LinkedList<>();
        if(root != null) currentRow.add(root);
        int max = Integer.MIN_VALUE;
        while(!currentRow.isEmpty()){
            TreeNode node = currentRow.remove();
            max = Math.max(max, node.val);
            if(node.left != null) nextRow.add(node.left);
            if(node.right != null) nextRow.add(node.right);
            if(currentRow.isEmpty()){
                currentRow = nextRow;
                nextRow = new LinkedList<>();
                result.add(max);
                max = Integer.MIN_VALUE;
            }
        }
        return result;
    }
}