class Solution {
    public boolean isBipartite(int[][] graph) {
        int v=graph.length; // finding the length of graph
        int color[]=new int[v]; // intialization of color array
        for(int i=0;i<v;i++) color[i]=-1;

        for(int i=0;i<v;i++){
            if(color[i]==-1){
                if(dfs(i,0,color,graph)==false) return false; // 
            }
        }
       return true; 
    }
   
   private boolean dfs(int node,int col,int[] color,int[][]graph){
    color[node]=col; // finding the color of parents node

    for (int i = 0; i < graph[node].length; i++) { // code to find adjency element of each node
    int adj = graph[node][i];
    if(color[adj]==-1){ 
          if(dfs(adj,1-col,color,graph)==false) return false;
        }
        else if(color[adj]==col){
             return false;
        }
    }
    return true;    
 }
}