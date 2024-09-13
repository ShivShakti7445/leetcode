// class Solution {
//     public int[] findOrder(int numCourses, int[][] prerequisites) {

//         // if(prerequisites==null || prerequisites[0]==0 )return new int[0];

//         ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
//         for(int i=0;i<numCourses;i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int i=0;i<prerequisites.length;i++){
//             adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
//         }

//         int vis[]=new int[numCourses];
//         int pathvis[]=new int[numCourses];
//         Stack<Integer> st=new Stack<>();

//         //boolean hasCycle = false;

//         for(int i=0;i<numCourses;i++){
//             if(vis[i]==0){
//                 if(dfs(i,vis,pathvis,st,adj)) return new int[0];
//             }
//         }
        
//         int[]ans=new int[numCourses];
//         for(int i=0;i<st.size();i++){
//            ans[i]=st.pop();
//         }

//         return ans;
//     }

//     private static boolean dfs(int node,int[]vis,int[]pathvis,Stack<Integer> st,ArrayList<ArrayList<Integer>> adj){
//         vis[node]=1;
//         pathvis[node]=1;

//         for(int it:adj.get(node)){
//             if(vis[it]==0){
//                if(dfs(it,vis,pathvis,st,adj)){
//                 return true;
//                }
//             }
            
//             else if(pathvis[it]==1)return true;
//         }

//         st.push(node);
//         pathvis[node]=0;

//         return false;
//     }
// }
import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Initialize adjacency list for the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Fill the adjacency list with the prerequisites
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] vis = new int[numCourses];
        int[] pathvis = new int[numCourses];
        Stack<Integer> st = new Stack<>();
        boolean hasCycle = false;

        // Perform DFS for each course
        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (dfs(i, vis, pathvis, st, adj)) {
                    // If a cycle is found, return an empty array
                    return new int[0];
                }
            }
        }

        // Fill the answer array from the stack in reverse order
        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = st.pop();
        }

        return ans;
    }

    // DFS function to detect cycles and perform topological sort
    private static boolean dfs(int node, int[] vis, int[] pathvis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        pathvis[node] = 1;

        for (int it : adj.get(node)) {
            // If the node is not visited, do DFS on it
            if (vis[it] == 0) {
                if (dfs(it, vis, pathvis, st, adj)) {
                    return true; // Cycle detected
                }
            } 
            // If the node is already in the current path, cycle detected
            else if (pathvis[it] == 1) {
                return true;
            }
        }

        st.push(node);
        pathvis[node] = 0; // Remove from the current path

        return false; // No cycle detected
    }
}
