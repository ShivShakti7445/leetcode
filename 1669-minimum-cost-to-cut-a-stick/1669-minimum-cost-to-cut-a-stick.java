class Solution {
    public int minCost(int n, int[] cuts) {
        // n=length of stick
        // int c=length of cuts
        int c=cuts.length;
        int newcuts[]=new int[c+2];
        System.arraycopy(cuts,0,newcuts,1,c);
        newcuts[0]=0;
        newcuts[c+1]=n;
        Arrays.sort(newcuts);
        int dp[][]=new int[c+2][c+2];
        for(int row[]:dp){
            Arrays.fill(row,0);
        }
        for(int i=c;i>=1;i--){
            for(int j=1;j<=c;j++){
                if(i>j) continue;
                int mini = Integer.MAX_VALUE;
                for(int ind=i;ind<=j;ind++){
                    int ans=newcuts[j+1]-newcuts[i-1]+dp[i][ind-1]+dp[ind+1][j];
                    mini=Math.min(mini,ans);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][c];
    }

}