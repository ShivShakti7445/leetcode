// class Solution {
//  class pair{
//     int row;int col;
//     pair(int row,int col){
//         this.row=row;
//         this.col=col;
//     }
//  }
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//        int r=image.length;
//        int c=image[0].length;
//         if(image[sr][sc]==color){
//         return image;
//         }

//        Queue<pair>q=new LinkedList<>();
//        q.add(new pair (sr,sc));
//         image[sr][sc]=color;
       

//         int[]drow={-1,0,1,0}; 
//         int []dcol={0,1,0,-1}; 



//         while(!q.isEmpty()){
//             int rr=q.peek().row;
//             int cc=q.peek().col;
//             q.remove();
            

//             for(int i=0;i<4;i++){
//                 int nrr=drow[i]+rr;
//                 int ncc=dcol[i]+cc;

//                 if(nrr>=0 && nrr<r && ncc>=0 && ncc<c && image[nrr][ncc]==image[sr][sc]){
//                     q.add(new pair(nrr,ncc));
//                     image[nrr][ncc]=color;
//                 }
//             }
//         }
       
//        return image;
//     }
// }

class Solution {
    class Pair {
        int row, col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int r = image.length;
        int c = image[0].length;
        int originalColor = image[sr][sc];

        // If the starting pixel is already the target color, no need to proceed
        if (originalColor == color) {
            return image;
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        image[sr][sc] = color; // Start with updating the initial pixel

        // Define the 4 possible directions (up, right, down, left)
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int rr = q.peek().row;
            int cc = q.peek().col;
            q.remove();

            // Check all four directions
            for (int i = 0; i < 4; i++) {
                int nrr = rr + drow[i];
                int ncc = cc + dcol[i];

                // Ensure the new position is within bounds and has the original color
                if (nrr >= 0 && nrr < r && ncc >= 0 && ncc < c && image[nrr][ncc] == originalColor) {
                    q.add(new Pair(nrr, ncc));
                    image[nrr][ncc] = color; // Fill the new pixel
                }
            }
        }

        return image;
    }
}
