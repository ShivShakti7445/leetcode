
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    class Node {
        Node link[] = new Node[2];

        boolean containsKey(int bit) {
            return (link[bit] != null);
        }

        Node get(int bit) {
            return link[bit];
        }

        void put(int bit, Node node) {
            link[bit] = node;
        }
    }

    class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        public void insert(int num) {
            Node node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (!node.containsKey(bit)) {
                    node.put(bit, new Node());
                }
                node = node.get(bit);
            }
        }

        int getMax(int num) {
            Node node = root;
            int max = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                // To check the opposite bit
                if (node.containsKey(1 - bit)) {
                    max = max | (1 << i);
                    node = node.get(1 - bit);
                } else {
                    node = node.get(bit);
                }
                // Handle the case when node becomes null
                if (node == null) {
                    break;
                }
            }
            return max;
        }
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];

        // List to store offline queries
        ArrayList<Pair<Integer, Pair<Integer, Integer>>> offlineQueries = new ArrayList<>();
        // Sort the array of numbers
        Arrays.sort(nums);

        int index = 0;

        // Convert queries to offline queries and store them in a list
        for (int[] it : queries) {
            offlineQueries.add(new Pair<>(it[1], new Pair<>(it[0], index++)));
        }

        // Sort offline queries based on their limits (second values)
        Collections.sort(offlineQueries, (a, b) -> a.getKey() - b.getKey());

        // Pointer to iterate through the array of numbers
        int i = 0;

        // Number of elements in the array
        int n = nums.length;

        // Create an instance of the Trie data structure
        Trie trie = new Trie();

        // Process each offline query
        for (Pair<Integer, Pair<Integer, Integer>> it : offlineQueries) {
            // Insert numbers into the trie until the current query's limit is reached
            while (i < n && nums[i] <= it.getKey()) {
                trie.insert(nums[i]);
                i++;
            }

            // If numbers were inserted into the Trie, find the maximum XOR
            if (i != 0)
                ans[it.getValue().getValue()] = trie.getMax(it.getValue().getKey());
            else
                // If no numbers inserted, set result to -1
                ans[it.getValue().getValue()] = -1;
        }
        // Return the results of all queries
        return ans;
    }
}
