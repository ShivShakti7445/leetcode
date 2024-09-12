
import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

       for(int i=0;i<numCourses;i++){
        adj.add(new ArrayList<>());
       }

       for(int i=0;i<prerequisites.length;i++){
        adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
       }

       int vis[]=new int [numCourses];
       int pathvis[]=new int [numCourses];

       Stack<Integer> st=new Stack<Integer>();

       for(int i=0;i<numCourses;i++){
        if(vis[i]==0){
            if(dfs(i,vis,st,adj,pathvis)){
                return false;
            }
        }
       }
       return true;

    }

    private static boolean dfs(int node,int[]vis,Stack<Integer>st,ArrayList<ArrayList<Integer>> adj,int[]pathvis){
        vis[node]=1;
        pathvis[node]=1;

        for(int it:adj.get(node)){
            if(vis[it]==0){
                if(dfs(it,vis,st,adj,pathvis)) return true;
            }

            if(pathvis[it]==1){
                return true;
            }
        }
     pathvis[node]=0;
     st.push(node);
     return false;
    }
}
