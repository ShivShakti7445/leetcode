class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int tsum=0;
        for(int i=0;i<n;i++) tsum+=nums[i];
        if(tsum%2!=0) return false;
        int sum=tsum/2;
        return isSubsetSum(n,nums,sum);
    }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        boolean [][]dp=new boolean [N][sum+1];
        for(int i=0;i<N;i++) dp[i][0]=true;// if target become zero
        if (arr[0] <= sum) dp[0][arr[0]]=true;//base case , if index become zero then arr[0]==target
        
        for(int i=1;i<N;i++){
            for(int target=1;target<=sum;target++){
                boolean nottake=dp[i-1][target];
                boolean take=false;
                if(arr[i]<=target) take=dp[i-1][target-arr[i]];
                
                dp[i][target]= take|| nottake;
            }
        }
        return dp[N-1][sum];
    }
}