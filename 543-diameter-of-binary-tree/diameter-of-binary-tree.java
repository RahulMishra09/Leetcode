/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res=0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }
    private int dfs(TreeNode root){
        if(root == null){
            return 0;

        }
        int ll=dfs(root.left);
        int lr=dfs(root.right);
        res=Math.max(res,ll+lr);
        return 1+Math.max(ll,lr);
    }
}