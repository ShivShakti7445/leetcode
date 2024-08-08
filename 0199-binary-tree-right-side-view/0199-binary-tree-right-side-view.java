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
    public List<Integer> rightSideView(TreeNode root) {
        class Pair{
            TreeNode node;
            int line;
            
            public Pair(TreeNode node,int line){
                this.node=node;
                this.line=line;
            }
            
        }
        
        List <Integer> ans=new ArrayList <Integer>();
        if(root==null) return ans;
        
        Queue<Pair> q=new LinkedList<Pair>();
        Map<Integer,Integer> map=new TreeMap<Integer,Integer>();
        
        q.add(new Pair(root,0));
        
        while(!q.isEmpty()){
            Pair pair=q.remove();
            int line=pair.line;
            TreeNode temp=pair.node;
            map.put(line,temp.val);
            
            
            
            
            if(temp.left!=null) q.add(new Pair(temp.left,line+1));
            if(temp.right!=null) q.add(new Pair(temp.right,line+1));
            
        }
        
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            ans.add(entry.getValue());
        }
        
        return ans;
    }
}