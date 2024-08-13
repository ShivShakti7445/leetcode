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
    public int countNodes(TreeNode root) {

        if(root==null) return 0;
        Queue<TreeNode> st=new LinkedList<>();
        st.offer(root);
        int ans=1;

        while(!st.isEmpty()){
            TreeNode node= st.poll();
            if(node.left!=null) {
                st.offer(node.left);
                ans+=1;
            }
            if(node.right!=null) {
                st.offer(node.right);
                ans+=1;
            }
        }
        return ans;
    }
}