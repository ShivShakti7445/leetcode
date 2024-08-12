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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;  // The width should be 0 if the root is null.
        }

        return ans(root);
    }

    private int ans(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> indices = new LinkedList<>(); // Track indices of nodes
        q.offer(root);
        indices.offer(0);
        int maxWidth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int left = indices.peek();  // Get the first (leftmost) index at the current level
            int right = left;  // Initialize the rightmost index as the leftmost

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                int index = indices.poll();
                right = index;  // Update the rightmost index

                if (node.left != null) {
                    q.offer(node.left);
                    indices.offer(2 * index + 1);
                }
                if (node.right != null) {
                    q.offer(node.right);
                    indices.offer(2 * index + 2);
                }
            }
            maxWidth = Math.max(maxWidth, right - left + 1);
        }

        return maxWidth;
    }
}