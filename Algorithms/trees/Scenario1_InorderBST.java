import java.util.*;
class Solution {
class TreeNode {
    int val;
    TreeNode left,right;
    TreeNode(int v){val=v;}
}

    public List<Integer> getSortedLeaderboard(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        inorder(root,ans);
        return ans;
    }
    private void inorder(TreeNode node,List<Integer> ans){
        if(node==null) return;
        inorder(node.left,ans);
        ans.add(node.val);
        inorder(node.right,ans);
    }
}