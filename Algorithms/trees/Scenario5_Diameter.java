class Solution {
class TreeNode {
    int val;
    TreeNode left,right;
    TreeNode(int v){val=v;}
}

    int dia=0;
    public int longestCommunicationPath(TreeNode root){
        dia=0;
        dfs(root);
        return dia;
    }
    int dfs(TreeNode node){
        if(node==null) return -1;
        int l=dfs(node.left), r=dfs(node.right);
        dia=Math.max(dia,l+r+2);
        return Math.max(l,r)+1;
    }
}