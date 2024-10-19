
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;  // Handle empty matrix case
        int n = matrix[0].length;
        int[] mat = new int[n];
        Arrays.fill(mat, 0);
        int area = 0;

        // Iterate over each row in the matrix
        for (int i = 0; i < matrix.length; i++) {
            // Update the histogram heights
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') mat[j] += 1;
                else mat[j] = 0;
            }
            // Get the maximum rectangle area for the current histogram
            int max = maximalRectangle(mat);
            area = Math.max(max, area);
        }
        return area;
    }

    // Helper method to calculate the maximal rectangle in a histogram
    static int maximalRectangle(int[] matrix) {
        int n = matrix.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n); // Initialize right boundaries with n (rightmost index)
        Stack<Integer> st = new Stack<>();

        // Find the left boundaries for the current histogram
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && matrix[st.peek()] >= matrix[i]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? 0 : st.peek() + 1;
            st.push(i);
        }

        // Clear the stack for re-use
        while (!st.isEmpty()) st.pop();

        // Find the right boundaries for the current histogram
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && matrix[st.peek()] >= matrix[i]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n - 1 : st.peek() - 1;
            st.push(i);
        }

        // Calculate the maximum area for this histogram
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max((right[i] - left[i] + 1) * matrix[i], ans);
        }
        return ans;
    }
}
