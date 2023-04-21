import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        List<Long> leftmost = new ArrayList<>();
        List<Long> rightmost = new ArrayList<>();
        int level = 0;
        boolean allChildrenNull = false;
        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> indecies = new Stack<>();
        s.add(root);
        indecies.add(0);
        while(!allChildrenNull){
            leftmost.add(Long.MAX_VALUE);
            rightmost.add(Long.MIN_VALUE);
            allChildrenNull = true;
            Stack<TreeNode> nextLevelNodes = new Stack<>();
            Stack<Integer> nextLevelIndecies = new Stack<>();
            while(!s.isEmpty()){
                int index = indecies.pop();
                TreeNode node = s.pop();
                if(node == null)
                    continue;
                long unsigned_index = Integer.toUnsignedLong(index);
                if(leftmost.get(level) > unsigned_index)
                    leftmost.set(level, unsigned_index);
                if(rightmost.get(level) < unsigned_index)
                    rightmost.set(level, unsigned_index);
                if(node.left != null || node.right != null)
                    allChildrenNull = false;
                nextLevelNodes.add(node.left);
                nextLevelNodes.add(node.right);
                nextLevelIndecies.add(index*2);
                nextLevelIndecies.add(index*2+1);
            }
            level++;
            s = nextLevelNodes;
            indecies = nextLevelIndecies;
        }

        int maxWidth = 0;
        for(int i = 0; i < level; i++){
            long width = rightmost.get(i) - leftmost.get(i) + 1;
            if((int) width > maxWidth){
                maxWidth = (int) width;
            }
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
