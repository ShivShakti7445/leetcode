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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0; 
        int[] ans=new int [1];
        height(ans,root);
        return ans[0];

    }

    private int height (int[] ans,TreeNode node){
        if(node==null) return 0;
        int lef=height(ans,node.left);
        int rt=height(ans,node.right);
        ans[0]=Math.max(ans[0],lef+rt);
        return 1+Math.max(lef,rt);
    }

   
}