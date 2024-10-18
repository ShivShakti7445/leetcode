class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,0);
        for(int i=n-1;i>=0;i--){
            int length=0;
            int maxi=Integer.MIN_VALUE;
            int ans=Integer.MIN_VALUE;
            for(int j=i;j<Math.min(n,i+k);j++){
                length++;
                maxi=Math.max(maxi,arr[j]);
                int sum= length*maxi + dp[j+1];
                ans=Math.max(sum,ans);
            }
            dp[i]=ans;
        }
        return dp[0];
    }
}