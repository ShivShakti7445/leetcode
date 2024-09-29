class Solution {

    int timer=1;
    private void dfs(int node,int parents,int[]vis,int[]low,int[]tin,List<List<Integer>> adj,List<List<Integer>> bridges){
        vis[node]=1;
        tin[node]=low[node]=timer;
        timer++;

        for(Integer it: adj.get(node)){
            if(parents==it) continue;
            if(vis[it]==0){
                 dfs(it,node,vis,low,tin,adj,bridges);
                 low[node]=Math.min(low[it],low[node]);
                 if(low[it]>tin[node]){ // code to check is theire any disjoint or not
                    bridges.add(Arrays.asList(node,it)); //jfkfk
                 }
            }
            else{
                 low[node]=Math.min(low[it],low[node]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //just for creating graph
        List<List<Integer>> adj=new ArrayList<>();
     for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
     } 
     for(List<Integer> li:connections) {
        int u=li.get(0);
        int v=li.get(1);
        adj.get(u).add(v);
        adj.get(v).add(u);
     }

     int [] tin=new int[n];
     int [] low=new int[n];
     int [] vis=new int[n];

     List<List<Integer>> bridges=new ArrayList<>();

     dfs(0,-1,vis,low,tin,adj,bridges);
     return bridges;

    }
}