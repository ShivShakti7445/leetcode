class Solution {
    class pair{
        int row;
        int col;
        int time;

        pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue <pair> q=new LinkedList<>();
        int[][] vis=new int[m][n];
        int cntfresh=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new pair(i,j,0));
                    vis[i][j]=2;
                }
                if(grid[i][j]==1){
                    cntfresh++;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }

        int time=0;
        int[]drow={-1,0,1,0};
        int []dcol={0,1,0,-1};
        int cnt=0;

        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().time;

            time=Math.max(time,t);
            q.remove();

            for(int i=0;i<4;i++){
                int nrow=r+drow[i];
                int ncol=c+dcol[i];

                if(nrow>=0&&nrow<m && ncol>=0&&ncol<n && vis[nrow][ncol]!=2 && grid[nrow][ncol]==1){
                    q.add(new pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]!=2 && grid[i][j]==1){
                    return -1;
                }
            }
        }

        return time;

    }
}