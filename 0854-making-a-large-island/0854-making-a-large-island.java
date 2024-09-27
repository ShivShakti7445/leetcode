public class Solution {

    class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();
        List<Integer> size = new ArrayList<>();  // Added to keep track of the size of components
        public DisjointSet(int n) { // Create list of parents, rank, and size
            for (int i = 0; i <= n; i++) {
                parent.add(i);
                rank.add(0);
                size.add(1);  // Initialize each component's size as 1
            }
        }

        public int findUPar(int node) { // It is used to find the ultimate parent of any node
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
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));  // Merge size
            } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));  // Merge size
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));  // Merge size
                rank.set(ulp_u, rank.get(ulp_u) + 1);
            }
        }
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);

        // Step 1: Union all adjacent 1's
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) continue;

                int[] dr = {-1, 0, 1, 0};  // Row directions: up, right, down, left
                int[] dc = {0, 1, 0, -1};  // Column directions: up, right, down, left

                for (int ind = 0; ind < 4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];

                    if (isValid(newr, newc, n) && grid[newr][newc] == 1) {
                        int nodeNo = row * n + col;
                        int adjNodeNo = newr * n + newc;
                        ds.unionByRank(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        // Step 2: Check every 0 cell and calculate the largest possible connected component
        int mx = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) continue;

                int[] dr = {-1, 0, 1, 0};  // Row directions
                int[] dc = {0, 1, 0, -1};  // Column directions

                HashSet<Integer> components = new HashSet<>();

                // Check all 4 directions around the 0 cell
                for (int ind = 0; ind < 4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];

                    if (isValid(newr, newc, n) && grid[newr][newc] == 1) {
                        components.add(ds.findUPar(newr * n + newc));
                    }
                }

                // Calculate the total size by adding the sizes of all unique components
                int sizeTotal = 0;
                for (Integer parent : components) {
                    sizeTotal += ds.size.get(parent);
                }

                mx = Math.max(mx, sizeTotal + 1);  // Plus 1 for the current 0 that can be changed to 1
            }
        }

        // Step 3: In case the grid has all 1's
        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            mx = Math.max(mx, ds.size.get(ds.findUPar(cellNo)));
        }

        return mx;
    }

    // Helper function to check if the cell is within grid bounds
    private boolean isValid(int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
 }