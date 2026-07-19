import java.util.*;
class Solution {
class TreeNode {
    int val;
    TreeNode left,right;
    TreeNode(int v){val=v;}
}

    public List<Integer> iterativePreorder(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Deque<TreeNode> st=new ArrayDeque<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode cur=st.pop();
            ans.add(cur.val);
            if(cur.right!=null) st.push(cur.right);
            if(cur.left!=null) st.push(cur.left);
        }
        return ans;
    }
}