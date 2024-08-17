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
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, new int[]{0});
    }
    
   private TreeNode constructBST(int[] preorder,int min,int max,int[]index){
    if(index[0]== preorder.length){
        return null;
    }
    
    
    int val=preorder[index[0]];

    if(val<min||val>max){
        return null;
    }

    index[0]++;

    TreeNode root=new TreeNode(val);
    root.left=constructBST(preorder, min,val,index);
    root.right=constructBST(preorder,val,max,index);

    return root;
   }
    
}