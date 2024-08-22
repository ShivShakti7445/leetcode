class Solution {
    public int findCircleNum(int[][] isConnected) {
        int ans=0;
        int node = isConnected.length;
        boolean [] vis=new boolean[node];
        for(int i=0;i<node;i++){
          if(!vis[i]){
           dfs(isConnected,vis,i);
           ans++;
          }
        }
        return ans;
    }
    private void dfs(int[][] isConnected,boolean [] vis,int i){
        vis[i]=true;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j]==1 && !vis[j]){
                dfs(isConnected,vis,j);
            }
        }
    }
}