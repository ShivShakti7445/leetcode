import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill the adjacency list
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }

        // Arrays to keep track of visited nodes and path nodes
        int[] vis = new int[graph.length];
        int[] pathvis = new int[graph.length];
        boolean[] safe = new boolean[graph.length];  // Array to store if a node is safe
        List<Integer> list = new ArrayList<>();

        // Perform DFS for each node
        for (int i = 0; i < graph.length; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, pathvis, adj, safe);
            }
        }

        // Add all safe nodes to the result list
        for (int i = 0; i < graph.length; i++) {
            if (safe[i]) {
                list.add(i);
            }
        }

        // Sort the list and return
        Collections.sort(list);
        return list;
    }

    // DFS function to detect cycles and mark safe nodes
    private static boolean dfs(int node, int[] vis, int[] pathvis, ArrayList<ArrayList<Integer>> adj, boolean[] safe) {
        vis[node] = 1;
        pathvis[node] = 1;

        // Traverse through all neighbors
        for (int it : adj.get(node)) {
            // If the neighbor has not been visited, do DFS
            if (vis[it] == 0) {
                if (!dfs(it, vis, pathvis, adj, safe)) {
                    return false;
                }
            } 
            // If the neighbor is in the current DFS path, a cycle is detected
            else if (pathvis[it] == 1) {
                return false;
            }
        }

        // Mark node as safe and remove from path
        pathvis[node] = 0;
        safe[node] = true;  // Mark the node as safe
        return true;
    }
}
