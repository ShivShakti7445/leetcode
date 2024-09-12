// // class Solution {
// //     public boolean canFinish(int numCourses, int[][] prerequisites) {
// //         boolean vis[]=new boolean [numCourses];
// //         Stack<Integer> st=new Stack<>();
        
// //         for(int i=0;i<prerequisites.length;i++){
// //             int first=prerequisites[i][0];
// //             int second=prerequisites[i][1];

// //             if(!st.contains(first)&& !vis[first]){
// //                 st.push(first);
// //                 vis[first]=true;
// //             }
// //             if(!st.contains(second)&&!vis[second]){
// //                 st.push(second);
// //                 vis[first]=true;
// //             }

// //             if(st.contains(first)&& vis[first]&&st.contains(second)&&vis[second]){
// //                 return false;
// //             }
// //         }

// //         if (vis.length==numCourses){
// //             return true;
// //         }

// //         return false;
// //     }
// // }


// import java.util.*;

// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {

//         ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
//         for(int i=0;i<numCourses;i++){
//             adj.add(new ArrayList<>());
//         }

//         for(int i=0;i<prerequisites.length;i++){
//             adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
//         }

//         int vis[]=new int[numCourses];
//         Stack<Integer> st=new Stack<>();
        
//        for (int i=0;i<numCourses;i++){
//            if(vis[i]==0){
//                dfs(i,vis,st,adj);
//            }
//         }
      
//        int []ans=new int[numCourses];
//        for(int i=0;i<numCourses;i++){
//            ans[i]=st.pop();
//           }

//        return st.size()==numCourses ;
//        }


//     private static void dfs(int node,int[]vis,Stack<Integer> st, ArrayList<ArrayList<Integer>> adj){
//         vis[node]=1;
        
//         for(int it:adj.get(node)){
//             if(vis[it]==0){
//                 dfs(it,vis,st,adj);
//             }
//         }
        
//         st.push(node);
//     }
// }


import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Create an adjacency list for graph representation
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill the adjacency list with the given prerequisites
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // Arrays to keep track of visited nodes and the recursion stack
        int vis[] = new int[numCourses];
        int recStack[] = new int[numCourses];
        Stack<Integer> st = new Stack<>();
        
        // Perform DFS for each course
        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                // If a cycle is detected, return false
                if (dfs(i, vis, recStack, st, adj)) {
                    return false; 
                }
            }
        }

        // If no cycle is found, return true (all courses can be completed)
        return true;
    }

    // DFS function to detect cycles and perform topological sort
    private static boolean dfs(int node, int[] vis, int[] recStack, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        // Mark the node as visited and add to recursion stack
        vis[node] = 1;
        recStack[node] = 1;

        // Visit all neighbors (adjacent nodes)
        for (int it : adj.get(node)) {
            // If the neighbor has not been visited, do DFS on it
            if (vis[it] == 0) {
                if (dfs(it, vis, recStack, st, adj)) {
                    return true;  // Cycle detected
                }
            } 
            // If the neighbor is already in the recursion stack, a cycle is detected
            else if (recStack[it] == 1) {
                return true;
            }
        }

        // After exploring all neighbors, mark the node as finished
        recStack[node] = 0;
        st.push(node); // Add to stack after all neighbors are processed

        return false; // No cycle detected
    }
}
