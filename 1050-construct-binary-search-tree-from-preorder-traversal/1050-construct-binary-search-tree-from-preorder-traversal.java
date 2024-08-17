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
    
    private TreeNode constructBST(int[] preorder, int min, int max, int[] index) {
        // Base case: if index is out of bounds, return null
        if (index[0] == preorder.length) {
            return null;
        }
        
        int val = preorder[index[0]];
        
        // If current value does not fit the range [min, max], return null
        if (val < min || val > max) {
            return null;
        }
        
        // Increment index for the next recursion
        index[0]++;
        
        // Create the root node with the current value
        TreeNode root = new TreeNode(val);
        
        // Recursively construct the left and right subtrees
        root.left = constructBST(preorder, min, val, index);   // Left subtree must have values less than val
        root.right = constructBST(preorder, val, max, index);  // Right subtree must have values greater than val
        
        return root;
    }
    
}