class Solution {
      class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                parent.add(i);
                rank.add(0);
            }
        }

        public int findUPar(int node) {
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
        for(int i=0;i<connections.length;i++){
            int u=connections[i][0];
            int v=connections[i][1];

            if(ds.findUPar(u)==ds.findUPar(v)){
                countextra++;
            }
            else{
                ds.unionByRank(u,v);
            }
        }
        int cn=0;

        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i){
                cn++;
            }
        }
        int ans=cn-1;
        if(ans<=countextra){
            return ans;
        }
        return -1;
    }
}