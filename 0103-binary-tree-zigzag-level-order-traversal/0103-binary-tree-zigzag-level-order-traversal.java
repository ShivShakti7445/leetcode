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
// 

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }
        int count = 0;
        return zigzag(root, count, ans);
    }

    private List<List<Integer>> zigzag(TreeNode root, int index, List<List<Integer>> ans) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            List<Integer> list = new LinkedList<Integer>();
            int n = q.size();

            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                if (index % 2 == 0) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val); // Add elements in reverse order
                }

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            ans.add(list);
            index++;
        }
        return ans;
    }
}