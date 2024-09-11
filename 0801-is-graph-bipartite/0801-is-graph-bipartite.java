class Solution {
    public boolean isBipartite(int[][] graph) {
        int v=graph.length;
        int vis[]=new int[v];
        for(int i=0;i<v;i++) vis[i]=-1;

        for(int i=0;i<v;i++){
            if(vis[i]==-1){
                if(!dfs(i,0,vis,graph)) return false;
            }
        }
       return true; 
    }
   
   private boolean dfs(int node,int col,int[] vis,int[][]graph){
    vis[node]=col;

    for (int i = 0; i < graph[node].length; i++) {
    int adj = graph[node][i];
    if(vis[adj]==-1){
            if(dfs(adj,1-col,vis,graph)==false) return false;
        }
        else if(vis[adj]==col){
             return false;
        }
    }
    return true;    
 }
}