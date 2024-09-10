// class Solution {
//     class pair{
//         int first;
//         int second;
//         pair(int first,int second){
//             this.first=first;
//             this.second=second;
//         }
//     }
//     public void solve(char[][] board) {
//         int n=board.length;
//          if (n == 0) return; 
//         int m=board[0].length;

//         Queue<pair> q=new LinkedList<>();
//         for(int  i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(board[i][j]=='O' && (i==0 && i==(n-1) && j==0&&i==(m-1))){
//                     q.add(new pair(i,j));
//                       board[i][j] = '#';
//                 }
//             }
//         }

//         int dr[]={-1,0,1,0};
//         int dc[]={0,1,0,-1};

//         while(!q.isEmpty()){
//             int row=q.peek().first;
//             int col=q.peek().second;

//             q.remove();

//             for(int i=0;i<4;i++){
//                 int nrow=row+dr[i];
//                 int ncol=row+dc[i];

//                 if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && board[nrow][ncol]=='O' ){
//                    // board[row][col]='X';
//                     q.add(new pair(nrow, ncol));
//                     board[nrow][ncol] = '#';
//                 }
//             }
//         }
//       for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (board[i][j] == 'O') {
//                     board[i][j] = 'X';  // Flip 'O' to 'X'
//                 } else if (board[i][j] == '#') {
//                     board[i][j] = 'O';  // Revert boundary-connected '#' back to 'O'
//                 }
//             }
//         }
//     }
// }

class Solution {
    class pair {
        int first;
        int second;
        pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        if (n == 0) return;  // Check for empty board
        int m = board[0].length;

        Queue<pair> q = new LinkedList<>();

        // Step 1: Add boundary 'O's and their connected 'O's to the queue and mark them as '#'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && board[i][j] == 'O') {
                    q.add(new pair(i, j));
                    board[i][j] = '#';  // Temporarily mark the boundary-connected 'O's
                }
            }
        }

        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};

        // Step 2: BFS to mark all 'O's connected to the boundary
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;

            q.remove();

            for (int i = 0; i < 4; i++) {
                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && board[nrow][ncol] == 'O') {
                    q.add(new pair(nrow, ncol));
                    board[nrow][ncol] = '#';  // Mark this 'O' as part of the boundary-connected region
                }
            }
        }

        // Step 3: Flip remaining 'O' to 'X' and revert '#' back to 'O'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';  // Flip 'O' to 'X'
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';  // Revert boundary-connected '#' back to 'O'
                }
            }
        }
    }
}
