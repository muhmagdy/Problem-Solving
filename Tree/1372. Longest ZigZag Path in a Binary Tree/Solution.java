import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int longestZigZag(TreeNode root) {
        int max = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visitedRight = new HashSet<>();
        Set<TreeNode> visitedLeft = new HashSet<>();        
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            boolean isRightVisited = visitedRight.contains(node);
            boolean isLeftVisisted = visitedLeft.contains(node);
            if(node == null || (isRightVisited && isLeftVisisted))
                continue;
            
            int zigZag = 0;
            if(!isRightVisited && !isLeftVisisted)
                zigZag = Math.max(longestZigZag(node, true, visitedRight, visitedLeft), longestZigZag(node, false, visitedRight, visitedLeft));
            else if(!isRightVisited)
                zigZag = longestZigZag(node, true, visitedRight, visitedLeft);
            else
                zigZag = longestZigZag(node, false, visitedRight, visitedLeft);
            if(zigZag > max)
                max = zigZag;
            queue.add(node.right);
            queue.add(node.left);
        }
        return max;
    }

    public static int longestZigZag(TreeNode node, boolean isRight, Set<TreeNode> visitedRight, Set<TreeNode> visitedLeft){
        int n = 0;
        while(node != null){
            if(isRight){
                if(n%2 == 0){
                    visitedRight.add(node);
                    node = node.right;
                }
                else{
                    visitedLeft.add(node);
                    node = node.left;
                }
            }
            else{
                if(n%2 == 0){
                    visitedLeft.add(node);
                    node = node.left;
                }
                else{
                    visitedRight.add(node);
                    node = node.right;
                }
            }
            n++;
        }
        return n;
    }
}



//Definition for a binary tree node.
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