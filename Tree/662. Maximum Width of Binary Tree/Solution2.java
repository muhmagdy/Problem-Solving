class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        TreeNode node = root;
        int leftmostIndex = 0, rightmostIndex = 0, leftmostLevel = 0, rightmostLevel = 0;
        //Find Leftmost
        while(node.left != null || node.right != null){
            if(node.left != null){
                leftmostIndex *= 2;
                node = node.left;
            }
            else{
                leftmostIndex = leftmostIndex*2 + 1;
                node = node.right;
            }
            leftmostLevel++;
        }

        node = root;
        //Find Rightmost
        while(node.left != null || node.right != null){
            if(node.right != null){
                rightmostIndex = rightmostIndex*2 + 1;
                node = node.right;
            }
            else{
                rightmostIndex *= 2;
                node = node.left;
            }
            rightmostLevel++;
        }
        
        if(rightmostLevel != leftmostLevel){
            int leastLevel = Math.min(leftmostLevel, rightmostLevel);
            if(leftmostLevel > leastLevel){
                node = root;
                leftmostIndex = 0;
                for(int i = 0; i < leastLevel; i++){
                    if(node.left != null){
                        leftmostIndex *= 2;
                        node = node.left;
                    }
                    else{
                        leftmostIndex = leftmostIndex*2 + 1;
                        node = node.right;
                    }
                }
            }else {
                node = root;
                //Find Rightmost
                rightmostIndex = 0;
                for(int i = 0; i < leastLevel; i++){
                    if(node.right != null){
                        rightmostIndex = rightmostIndex*2 + 1;
                        node = node.right;
                    }
                    else{
                        rightmostIndex *= 2;
                        node = node.left;
                    }
                }
            }
        }

        return rightmostIndex-leftmostIndex+1;     
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
