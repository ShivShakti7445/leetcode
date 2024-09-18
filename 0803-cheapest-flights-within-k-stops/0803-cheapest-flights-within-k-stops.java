// class Solution {
//     class pair{
//         int first,second;
//         pair(int first,int second){
//             this.first=first;
//             this.second=second;
//         }
//     }
//      class triple{
//         int first,second,third;
//         triple(int first,int second,int third){
//             this.first=first;
//             this.second=second;
//             this.third=third;
//         }
//     }
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
//         ArrayList<ArrayList<ArrayList<pair>>> adj=new ArrayList<>();
//         for(int i=0;i<n;i++){
//             adj.add(new ArrayList<>());
//         }

//         int m=flights.length;
//         for(int i=0;i<m;i++){
//             adj.get(flights[i][0]).add(new pair (flights[i][1],flights[i][2]));
//         }

//         Queue<triple> q=new LinkedList<>();
//         q.add(new triple(0,src,0));

//         int dis[]=new int[n];
//         Arrays.fill(dis,(int)1e9);

//         dis[src]=0;

//         while(!q.isEmpty()){
//             triple curr=q.peek();
//             q.remove();
//             int stop=curr.first;
//             int node=curr.second;
//             int dist=curr.third;

//             for(pair pr:adj.get(node)){
//                   int adjnode=pr.first;
//                   int adjwt=pr.second;
//                   if(stop>k) continue;

//                   if(dist+adjwt<flight[adjnode] && stop<=k){
//                     flight[adjnode]=dist+adjwt;
//                     q.add(new triple(stop+1,adjnode,dist+adjwt));
//                   }
//             }
//         }
//       if(dis[dst]==(int)1e9) return -1;
//       return dis;
//     }
// }


class Solution {
    class pair {
        int first, second;
        pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    class triple {
        int first, second, third;
        triple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        // Adjacency list with each node having pairs (destination, weight)
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding the flight details to the adjacency list
        int m = flights.length;
        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new pair(flights[i][1], flights[i][2]));
        }

        // Queue to perform BFS with (stops, node, cost)
        Queue<triple> q = new LinkedList<>();
        q.add(new triple(0, src, 0));

        // Distance array to track the minimum cost to reach each node
        int dis[] = new int[n];
        Arrays.fill(dis, (int)1e9);
        dis[src] = 0;

        // BFS loop
        while (!q.isEmpty()) {
            triple curr = q.peek();
            q.remove();
            int stop = curr.first;
            int node = curr.second;
            int dist = curr.third;

            // Skip if the number of stops exceeds the limit
            if (stop > k) continue;

            // Traverse through adjacent nodes
            for (pair pr : adj.get(node)) {
                int adjnode = pr.first;
                int adjwt = pr.second;
                
                // If a shorter path is found
                if (dist + adjwt < dis[adjnode]) {
                    dis[adjnode] = dist + adjwt;
                    q.add(new triple(stop + 1, adjnode, dis[adjnode]));
                }
            }
        }

        // If destination is unreachable, return -1
        if (dis[dst] == (int)1e9) return -1;
        
        // Return the minimum cost to reach the destination
        return dis[dst];
    }
}
