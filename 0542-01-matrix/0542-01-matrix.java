                              /* code for nearest 1*/ 
// class Solution {
//     class pair{
//         int first;
//         int second;
//         int third;

//         pair( int first,int second,int third){
//             this.first=first;
//             this.second=second;
//             this.third=third;
//         }
//     }
//     public int[][] updateMatrix(int[][] mat) {
//         int n=mat.length;
//         int m=mat[0].length;

//         int vis[][]=new int[n][m];
//         int dis[][]=new int [n][m];
//         Queue<pair> q=new LinkedList<>();

//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(mat[i][j]==1){
//                     vis[i][j]=1;
//                     q.add(new pair(i,j,1));
//                 }
//                 else{
//                     vis[i][j]=0;
//                 }
//             }
//         }

//         int []dr={-1,0,1,0};
//         int []dc={0,1,0,-1};

//         while(!q.isEmpty()){
//             int row=q.peek().first;
//             int col=q.peek().second;
//             int step=q.peek().third;
//             q.remove();
            
//             dis[row][col]=step;

//             for(int k=0;k<4;k++){
//                 int nrow=row+dr[k];
//                 int ncol=col+dc[k];

//                  if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
//                     vis[nrow][ncol]=1;    
//                     q.add(new pair(nrow,ncol,step+1));
//                  }
               
//             }
//         }
//     return dis;

//     }
// }
class Solution {
    // Class representing a coordinate pair with distance
    class Pair{
        int first;
        int second;
        int third;

        // Constructor for the Pair class
        Pair( int first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    
    // Function to update the matrix with the nearest 0 distances
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // Visited array to keep track of processed nodes
        int vis[][] = new int[n][m];
        // Distance array to store the distances from the nearest 0
        int dis[][] = new int [n][m];
        Queue<Pair> q = new LinkedList<>();  // Queue for BFS traversal

        // Initialize the BFS queue with positions of all 0's
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0){  // If current cell is 0
                    vis[i][j] = 1;  // Mark it visited
                    q.add(new Pair(i, j, 0));  // Add to queue with step = 0
                }
                else{
                    vis[i][j] = 0;  // Unvisited for 1's initially
                }
            }
        }

        // Direction arrays to move in the 4 possible directions (up, right, down, left)
        int []dr = {-1, 0, 1, 0};
        int []dc = {0, 1, 0, -1};

        // BFS traversal to update distances
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int step = q.peek().third;
            q.remove();
            
            dis[row][col] = step;  // Update distance array

            // Explore all 4 possible directions
            for(int k = 0; k < 4; k++){
                int nrow = row + dr[k];  // New row
                int ncol = col + dc[k];  // New column

                 // If new position is within bounds and not yet visited
                 if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;  // Mark as visited
                    q.add(new Pair(nrow, ncol, step + 1));  // Add new position with incremented step
                 }
            }
        }
        return dis;  // Return the distance array
    }
}
