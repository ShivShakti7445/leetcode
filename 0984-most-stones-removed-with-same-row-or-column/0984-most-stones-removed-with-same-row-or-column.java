
class Solution {
    class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();

        public DisjointSet(int n) { // create list of parents and rank
            for (int i = 0; i <= n; i++) {
                parent.add(i);
                rank.add(0);
            }
        }

        public int findUPar(int node) { // find ultimate parent
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
                rank.set(ulp_u, rank.get(ulp_u) + 1);
            }
        }
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;

        // Find the maximum row and column value
        for (int i=0;i<n;i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        // Create disjoint set large enough to accommodate all rows and columns
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        HashMap<Integer,Integer>stoneNode=new HashMap<>();
        for (int i=0;i<n;i++) {
            int row = stones[i][0];
            int col = stones[i][1] + maxRow + 1; // Offset column index to make it unique
            ds.unionByRank(row, col);
            stoneNode.put(row,1);
            stoneNode.put(col,1);

        }

        // Count the number of connected components
        int cc = 0;
        for (Map.Entry<Integer,Integer>it:stoneNode.entrySet()) {
            if (ds.findUPar(it.getKey()) == it.getKey()) {
                cc++;
            }
        }

        // The result is the total number of stones minus the number of connected components
        return n - cc;
    }
}
