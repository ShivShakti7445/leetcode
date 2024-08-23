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
        int m=grid.length;  // for finding no. of row
        int n=grid[0].length; // for finding no. of coloum
        Queue <pair> q=new LinkedList<>();
        int[][] vis=new int[m][n]; // 2D array for finding whether you are visited or not
        int cntfresh=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){      // here is the code for travrasal each elemnt of grid 2d array , and adding all the element which having the value =2
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
        int[]drow={-1,0,1,0};  // it is single 1D array for neighbour row for their position
        int []dcol={0,1,0,-1};  //  it is single 1D array for neighbour coloum for their position
        int cnt=0;

        while(!q.isEmpty()){
            int r=q.peek().row;  // extrecting row for queue
            int c=q.peek().col;  // extrecting cloum for queue
            int t=q.peek().time;  // extrecting time for queue

            time=Math.max(time,t);   // code for finding max. time taken
            q.remove();

            for(int i=0;i<4;i++){    // code for travarsing to each neighbour
                int nrow=r+drow[i];  // code for fingind new neighbour row element
                int ncol=c+dcol[i];  // code for fingind new neighbour coloum element

                if(nrow>=0&&nrow<m && ncol>=0&&ncol<n && vis[nrow][ncol]!=2 && grid[nrow][ncol]==1){//condion for checking whether new elements is perfect elements or not
                    q.add(new pair(nrow,ncol,t+1)); // if yes than add to it in queue
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]!=2 && grid[i][j]==1){  // code for checking if any elements left in grid array whoes value is 1 then retuern -1
                    return -1;
                }
            }
        }

        return time;

    }
}