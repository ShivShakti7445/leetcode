class Solution {
    public int minDistance(String word1, String word2) {
        return maxipalindromiclength(word1,word2);
    }
    static int maxipalindromiclength(String s, String t){
        int n=s.length();
        int m=t.length();
        if(s.equals(t)) return 0;
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++) dp[i][0]=0;
        for(int i=0;i<=m;i++) dp[0][i]=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                
                if(s.charAt(i-1)==t.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else{
                     dp[i][j]=0+Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
     if(dp[n][m]==0) return (n+m);
     return (n+m-2*dp[n][m]);
    }
}