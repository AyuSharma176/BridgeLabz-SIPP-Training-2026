import java.util.*;
class Solution {
class TreeNode {
    int val;
    TreeNode left,right;
    TreeNode(int v){val=v;}
}

    public List<List<Integer>> broadcastByLevel(TreeNode root){
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int sz=q.size();
            List<Integer> lvl=new ArrayList<>();
            while(sz-->0){
                TreeNode n=q.poll();
                lvl.add(n.val);
                if(n.left!=null) q.offer(n.left);
                if(n.right!=null) q.offer(n.right);
            }
            res.add(lvl);
        }
        return res;
    }
}