// //               code of memoization {Time Limit Exceeded}

// class Solution {
//     public int rob(int[] nums) {
//         int n=nums.length;
//         int []dp=new int[n+1];
//         return maximum(n-1,nums,dp);
//     }

//     static int maximum(int ind,int []nums,int []dp){
//         if(ind==0) return nums[ind];
//         if(ind<0) return 0;

//         if(dp[ind]!=0) return dp[ind];
//         int peek=nums[ind]+maximum(ind-2,nums,dp);
//         int notpeek=0+maximum(ind-1,nums,dp);

//         return (dp[ind]=Math.max(peek,notpeek));
//     }
// }


// *********************************************************
 //               code of tabulation

class Solution {
    public int rob(int[] nums) {
    int n=nums.length;
    if(n==0) return 0; // If there are no houses
    if(n==1) return nums[0]; // If there is only one house
    int dp[]= new int[n]; // Create a dp array to store the maximum amount that can be robbed up to each house
    // Base cases
    dp[0]=nums[0];// If there's only one house, rob it
    dp[1]=Math.max(nums[0], nums[1]);// For two houses, rob the one with the maximum money
// Fill the dp array using the relation dp[i] = max(rob current house, skip current house)
   for(int i=2;i<n;i++){
    int rob=nums[i]+dp[i-2];
    int notrob=0+dp[i-1];
    dp[i]=Math.max(rob,notrob);
   }
return dp[n - 1]; // // The last element in dp contains the result: the maximum amount we can rob

    }
}
