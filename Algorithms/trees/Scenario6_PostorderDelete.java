class Solution {
class TreeNode {
    int val;
    TreeNode left,right;
    TreeNode(int v){val=v;}
}

    void deleteNode(TreeNode node){
        System.out.println("Deleted "+node.val);
    }
    void deleteFolderTree(TreeNode node){
        if(node==null) return;
        deleteFolderTree(node.left);
        deleteFolderTree(node.right);
        deleteNode(node);
    }
}