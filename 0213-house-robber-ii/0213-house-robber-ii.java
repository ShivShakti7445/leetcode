class Solution {
    int rober(int[] nums) {

    int n=nums.length;
    if(n==0) return 0; // If there are no houses
    if(n==1) return nums[0]; // If there is only one house
    int dp[]= new int[n]; // Create a dp array to store the maximum amount that can be robbed 
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

     public int rob(int[] nums) {
       if(nums.length==1) return nums[0];
       int [] temp1=new int[nums.length];
       int temp2[]=new int [nums.length];
       for(int i=0;i<nums.length;i++){
        if(i!=0) temp1[i]=nums[i];
        if(i!=(nums.length-1)) temp2[i]=nums[i];
       }

       return Math.max(rober(temp1),rober(temp2));
     }
}