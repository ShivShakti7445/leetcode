import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        int l = 0;
        int r = 0;
        
        // Sort both arrays in ascending order
        Arrays.sort(g);
        Arrays.sort(s);
        
        // Iterate while both pointers are within array bounds
        while (l < n && r < m) {
            // If the current size of the cookie satisfies the child
            if (g[l] <= s[r]) {
                r++; // Move to the next cookie
                l++; // Move to the next child
            } else {
                r++; // Move to the next cookie if the current one is too small
            }
        }
        return l; // Number of children that were satisfied
    }
}
