class Solution {
class TreeNode {
    int val;
    TreeNode left,right;
    TreeNode(int v){val=v;}
}

    int height(TreeNode node){
        if(node==null) return -1;
        return Math.max(height(node.left),height(node.right))+1;
    }
    boolean isTooDeep(TreeNode root,int threshold){
        return height(root)>threshold;
    }
}