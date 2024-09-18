// class Solution {
//     class Triple {
//         int distance;
//         int row;
//         int col;

//         Triple(int distance, int row, int col) {
//             this.distance = distance;
//             this.row = row;
//             this.col = col;
//         }
//     }

//     public int minimumEffortPath(int[][] heights) {
        
//         int n = heights.length;
//         int m = heights[0].length;

//         int[] dr = {-1,0, 1,0};
//         int[] dc = {0,1,0,-1};

//         PriorityQueue<Triple> pq=new PriorityQueue<>(Comparator.comparingInt(x->x.distance));
        
//         int effort[][]=new int[n][m];
//         for(int row[]: effort){
//             Arrays.fill(row,(int)1e9);
//         }
//         effort[0][0]=0;

//         pq.add(new Triple(0,0,0));
//         //int ans=0;

//         while(!pq.isEmpty()){
//             Triple index=pq.poll();
//             int currDis=index.distance;
//             int r=index.row;
//             int c=index.col;
//             if(r==(n-1) && c==(m-1)) return currDis;

//             int rd[]={-1,0,1,0};
//             int rc[]={0,1,0,-1};

//             for(int i=0;i<4;i++){
//                 int nr=r+rd[i];
//                 int nc=c+rc[i];
//                 if(nr>=0&& nr<n && nc>=0&&nc<m){
//                     int neweffo=Math.max(currDis,Math.abs(heights[nr][nc]-heights[r][c]));
//                     if(neweffo<effort[nr][nc]){
//                         effort[nr][nc]=neweffo;
//                     }
//                     pq.add(new Triple(neweffo,nr,nc));
//                 }
//             }
//         }
//         return 0;
//     }
// }

import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    class Triple {
        int distance;
        int row;
        int col;

        Triple(int distance, int row, int col) {
            this.distance = distance;
            this.row = row;
            this.col = col;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        PriorityQueue<Triple> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));
        pq.add(new Triple(0, 0, 0));

        int[][] effort = new int[n][m];
        for (int[] row : effort) {
            java.util.Arrays.fill(row, Integer.MAX_VALUE);
        }
        effort[0][0] = 0;

        while (!pq.isEmpty()) {
            Triple index = pq.poll();
            int currDis = index.distance;
            int r = index.row;
            int c = index.col;

            if (r == n - 1 && c == m - 1) return currDis;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int newEffort = Math.max(currDis, Math.abs(heights[nr][nc] - heights[r][c]));

                    if (newEffort < effort[nr][nc]) {
                        effort[nr][nc] = newEffort;
                        pq.add(new Triple(newEffort, nr, nc));
                    }
                }
            }
        }
        return 0;
    }
}
