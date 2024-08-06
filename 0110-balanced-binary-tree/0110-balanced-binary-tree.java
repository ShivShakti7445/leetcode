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
    public boolean isBalanced(TreeNode root) {
     return mdf(root)!=-1;
    }

    private int mdf(TreeNode root){
        if(root==null){
            return 0;
        }
        int le=mdf(root.left);
        if(le == -1) return -1;
        int rt=mdf(root.right);
        if(rt == -1) return -1; 
        if(Math.abs(le-rt)>1){
            return -1;
        }

        return 1+Math.max(le,rt);
    }
}