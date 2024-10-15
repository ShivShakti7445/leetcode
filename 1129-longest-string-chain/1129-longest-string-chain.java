// class Solution {
//     public int longestStrChain(String[] words) {
//         int n=words.length;
//         int dp[]=new int[n];
//         Arrays.fill(dp,1);
//         int max=1;
//         for(int i=1;i<n;i++){
//              for(int j=0;j<i;j++){
//              if(words[i].contains(words[j])&& words[i].length()==words[j].length()+1){
//                 dp[i]=Math.max(1+dp[j],words[i].length());
//                 max=Math.max(max,dp[i]);
//              }
//             } 
//         }
//        return max; 
//     }
// }

class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);  // Initially, the chain length for each word is at least 1
        int max = 1;
        
        // Sort the words by their lengths
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
    
    private boolean isPredecessor(String word1, String word2) {
        if (word1.length() + 1 != word2.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            if (word1.charAt(i) == word2.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == word1.length();  // Return true if we used all chars from word1
    }
}
