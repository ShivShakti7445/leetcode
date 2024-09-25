class Solution {
      class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();

        public DisjointSet(int n) { // create list of parents ans rank
            for (int i = 0; i <= n; i++) {
                parent.add(i);
                rank.add(0);
            }
        }

        public int findUPar(int node) { // it is used to find the ultimate parent of any node
            if (node == parent.get(node)) {
                return node;
            }
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void unionByRank(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) return;

            if (rank.get(ulp_u) < rank.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
            } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u);
            } else {
                parent.set(ulp_v, ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u, rankU + 1);
            }
        }
    }

    // Edge class to represent graph edges
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.weight = wt;
        }

        // Compare edges based on their weights
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds= new  DisjointSet(n);
        int countextra=0;

        // code for finding the extra edges
        for(int i=0;i<connections.length;i++){
            int u=connections[i][0];
            int v=connections[i][1];

            if(ds.findUPar(u)==ds.findUPar(v)){
                countextra++; // of u and v havd same ultimate parent then it means , this is the extra edges
            }
            else{
                ds.unionByRank(u,v); // otherwise do the union of the edges
            }
        }
        int cn=0;

        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i){
                cn++; // cont for counting the no. of connected edges (concept is: node witch having parent of themselve, that only edge contribute into no, of edges )
            }
        }
        int ans=cn-1;
        if(ans<=countextra){
            return ans;
        }
        return -1;
    }
}