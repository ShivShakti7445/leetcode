class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // first make the 2D matrix of distance of each vertex to each other vertex
        int dis[][]=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                dis[i][j] = Integer.MAX_VALUE;
        }

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            dis[u][v]=w;
            dis[v][u]=w;
        }

        for(int i=0;i<n;i++){
            dis[i][i]=0;
        }


// Floyd Warshall algorithm

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dis[i][k]==Integer.MAX_VALUE || dis[k][j]==Integer.MAX_VALUE) continue;
                    dis[i][j]=Math.min(dis[i][j],dis[i][k]+dis[k][j]);
                }
            }
        }

// code for checking cityno;
        int cntcity=n;
        int cityno=-1;

        for(int i=0;i<n;i++){
            int cnt=0;
             for(int j=0;j<n;j++){
                if(dis[i][j]<= distanceThreshold) cnt++ ;
            }

            if(cnt<=cntcity){
                cntcity=cnt;
                cityno=i;
            }

        }
        return cityno;
    }
}