// class Solution {
//     class pair{
//         int first,second;
//         pair(int first,int second){
//             this.first=first;
//             this.second=second;
//         }
//     }
//     public int countPaths(int n, int[][] roads) {
//         ArrayList<ArrayList<pair>> adj=new ArrayList<>();

//         for(int i=0;i<n;i++){
//             adj.add(new ArrayList<>());
//         }

//         for(int i=0;i<roads.length;i++){
//             adj.get(roads[i][0]).add(new pair(roads[i][1],roads[i][2]));
//             adj.get(roads[i][1]).add(new pair(roads[i][0],roads[i][2]));
//         }

//         PriorityQueue<pair> pq=new PriorityQueue<>((x,y)->x.first-y.first);
//         int dis[]=new int[n];
//         Arrays.fill(dis,(int)1e9);
//         int ways[]=new int[n];
//         Arrays.fill(ways,0);
//         dis[0]=0;
//         ways[0]=1;
//         pq.add(new pair(0,0));//dis,node
//         int mod=(int)(1e9+7);


//         while(pq.size()!=0){
//             int dist=pq.peek().first;
//             int node=pq.peek().second;
//             pq.remove();

//             for(pair curr: adj.get(node)){
//                 int adjnode=curr.first;
//                 int adjdis=curr.second;

//                 if(dist+adjdis<dis[adjnode]){
//                     dis[adjnode]=dist+adjdis;
//                     pq.add(new pair(dis[adjnode],adjnode));
//                     ways[adjnode]=ways[node];
//                 }

//                 else if(dist+adjdis==dis[adjnode]) {
//                     ways[adjnode]=(ways[node]+ways[adjnode])%mod;
//                 }
//             }
//         }
//        return ways[n-1]%mod;
//     }
// }
// class Solution {
//     class pair {
//         int first, second;
//         pair(int first, int second) {
//             this.first = first;
//             this.second = second;
//         }
//     }

//     public int countPaths(int n, int[][] roads) {
//         ArrayList<ArrayList<pair>> adj = new ArrayList<>();

//         for (int i = 0; i < n; i++) {
//             adj.add(new ArrayList<>());
//         }

//         for (int i = 0; i < roads.length; i++) {
//             adj.get(roads[i][0]).add(new pair(roads[i][1], roads[i][2]));
//             adj.get(roads[i][1]).add(new pair(roads[i][0], roads[i][2]));
//         }

//         PriorityQueue<pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
//         int dis[] = new int[n];
//         Arrays.fill(dis, (int) 1e9);
//         int ways[] = new int[n];
//         Arrays.fill(ways, 0);
//         dis[0] = 0;
//         ways[0] = 1;
//         pq.add(new pair(0, 0)); // dis, node
//         int mod = (int) (1e9 + 7); // Corrected mod value

//         while (!pq.isEmpty()) {
//             int dist = pq.peek().first;
//             int node = pq.peek().second;
//             pq.poll(); // Using poll() instead of remove()

//             for (pair curr : adj.get(node)) {
//                 int adjnode = curr.first;
//                 int adjdis = curr.second;

//                 if (dist + adjdis < dis[adjnode]) {
//                     dis[adjnode] = dist + adjdis;
//                     pq.add(new pair(dis[adjnode], adjnode));
//                     ways[adjnode] = ways[node];
//                 } else if (dist + adjdis == dis[adjnode]) {
//                     ways[adjnode] = (ways[node] + ways[adjnode]) % mod;
//                 }
//             }
//         }
//         return ways[n - 1] % mod;
//     }
// }
// class Solution {
//     class pair {
//         int first, second;
//         pair(int first, int second) {
//             this.first = first;
//             this.second = second;
//         }
//     }

//     public int countPaths(int n, int[][] roads) {
//         ArrayList<ArrayList<pair>> adj = new ArrayList<>();

//         for (int i = 0; i < n; i++) {
//             adj.add(new ArrayList<>());
//         }

//         for (int i = 0; i < roads.length; i++) {
//             adj.get(roads[i][0]).add(new pair(roads[i][1], roads[i][2]));
//             adj.get(roads[i][1]).add(new pair(roads[i][0], roads[i][2]));
//         }

//         PriorityQueue<pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
//         int dis[] = new int[n];
//         Arrays.fill(dis, (int) 1e9);
//         int ways[] = new int[n];
//         Arrays.fill(ways, 0);
//         dis[0] = 0;
//         ways[0] = 1;
//         pq.add(new pair(0, 0)); // dis, node
//         int mod = (int) (1e9 + 7); // Corrected mod value

//         while (!pq.isEmpty()) {
//             int dist = pq.peek().first;
//             int node = pq.peek().second;
//             pq.poll(); // Using poll() instead of remove()

//             if (dist > dis[node]) {
//                 continue; // Skip if the node has already been processed with a shorter distance
//             }

//             for (pair curr : adj.get(node)) {
//                 int adjnode = curr.first;
//                 int adjdis = curr.second;

//                 if (dist + adjdis < dis[adjnode]) {
//                     dis[adjnode] = dist + adjdis;
//                     pq.add(new pair(dis[adjnode], adjnode));
//                     ways[adjnode] = ways[node];
//                 } else if (dist + adjdis == dis[adjnode]) {
//                     ways[adjnode] = (ways[node] + ways[adjnode]) % mod;
//                 }
//             }
//         }
//         return ways[n - 1] % mod;
//     }
// }

// class Solution {
//     class pair {
//         int first, second;
//         pair(int first, int second) {
//             this.first = first;
//             this.second = second;
//         }
//     }

//     public int countPaths(int n, int[][] roads) {
//         ArrayList<ArrayList<pair>> adj = new ArrayList<>();

//         for (int i = 0; i < n; i++) {
//             adj.add(new ArrayList<>());
//         }

//         for (int i = 0; i < roads.length; i++) {
//             adj.get(roads[i][0]).add(new pair(roads[i][1], roads[i][2]));
//             adj.get(roads[i][1]).add(new pair(roads[i][0], roads[i][2]));
//         }

//         PriorityQueue<pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
//         int dis[] = new int[n];
//         Arrays.fill(dis, (int) 1e9);
//         int ways[] = new int[n];
//         Arrays.fill(ways, 0);
//         dis[0] = 0;
//         ways[0] = 1;
//         pq.add(new pair(0, 0)); // dis, node
//         int mod = (int) (1e9 + 7); // Corrected mod value

//         while (!pq.isEmpty()) {
//             int dist = pq.peek().first;
//             int node = pq.peek().second;
//             pq.poll(); // Using poll() instead of remove()

//             if (dist > dis[node]) {
//                 continue; // Skip if the node has already been processed with a shorter distance
//             }

//             for (pair curr : adj.get(node)) {
//                 int adjnode = curr.first;
//                 int adjdis = curr.second;

//                 if (dist + adjdis < dis[adjnode]) {
//                     dis[adjnode] = dist + adjdis;
//                     ways[adjnode] = ways[node]; // Update ways correctly
//                     pq.add(new pair(dis[adjnode], adjnode));
//                 } else if (dist + adjdis == dis[adjnode]) {
//                     ways[adjnode] = (ways[node] + ways[adjnode]) % mod;
//                 }
//             }
//         }
//         return ways[n - 1] % mod;
//     }
// }

import java.util.*;

class Solution {
    class Pair {
        long first;
        int second;
        
        Pair(long first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int countPaths(int n, int[][] roads) {
        // Adjacency list representation of graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Building the adjacency list
        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][2], roads[i][1]));
            adj.get(roads[i][1]).add(new Pair(roads[i][2], roads[i][0]));
        }

        // Priority queue for Dijkstra's algorithm (min-heap)
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.first, y.first));
        
        // Distance array and ways array
        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE); // Use Long.MAX_VALUE for large values
        int[] ways = new int[n];
        Arrays.fill(ways, 0);

        dis[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0)); // distance to node 0 is 0

        int mod = (int) (1e9 + 7); // For modding the result

        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            long dist = pq.peek().first;
            int node = pq.peek().second;
            pq.poll();

            for (Pair curr : adj.get(node)) {
                int adjNode = curr.second;
                long adjDist = curr.first;

                // Relaxation step
                if (dist + adjDist < dis[adjNode]) {
                    dis[adjNode] = dist + adjDist;
                    pq.add(new Pair(dis[adjNode], adjNode));
                    ways[adjNode] = ways[node]; // Update ways to reach adjNode
                } else if (dist + adjDist == dis[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1] % mod;
    }
}
