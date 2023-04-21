import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Definition for a binary tree node. */
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
 
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> nums = new HashSet<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        while(node != null || !s.empty()){
            if(node != null){
                s.push(node);
                node = node.left;
            }
            else{
                node = s.pop();
                if(nums.contains(k-node.val))
                    return true;
                nums.add(node.val);
                node = node.right;
            }
        }
        return false;
    }
}