class Solution {
    public int reverse(int x) {
        int result = 0;
        
        while (x != 0) {
            int rem = x % 10;
            x = x / 10;
            
            // Check for overflow before adding the next digit
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && rem > 7)) {
                return 0; // Overflow for positive numbers
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && rem < -8)) {
                return 0; // Overflow for negative numbers
            }
            
            result = result * 10 + rem;
        }
        
        return result;
    }
}
