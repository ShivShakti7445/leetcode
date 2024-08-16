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
// class Solution {
//     public TreeNode insertIntoBST(TreeNode root, int val) {
//         TreeNode node= root;
//         while(node!=null){
//             if(val>node.val){
//                node=node.right;
//                if(node==null) {node=new TreeNode(val);
//                 return root;}
//             }
//             else{
//                 node=node.left;
//                 if(node==null) {node =new TreeNode(val);
                                
//                                    return root;}
//             }
//         }
//         return root;
//     }
// }

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);  // If the tree is empty, return the new node as root
        
        TreeNode node = root;
        while (node != null) {
            if (val > node.val) {
                if (node.right == null) {  // If the right child is null, insert the new node here
                    node.right = new TreeNode(val);
                    return root;
                } else {
                    node = node.right;  // Move to the right child
                }
            } else {
                if (node.left == null) {  // If the left child is null, insert the new node here
                    node.left = new TreeNode(val);
                    return root;
                } else {
                    node = node.left;  // Move to the left child
                }
            }
        }
        return root;  // Return the modified tree root
    }
}
