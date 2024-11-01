class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
      return(fun(nums,goal)-fun(nums,goal-1)); 
    }
    static int fun(int[] nums, int goal){
       if(goal<0)return 0;
       int n=nums.length;
        int l=0;
        int r=0;
        int total=0;
        int ans=0;
        while(r<n){
          total+=nums[r];
          while(total>goal){
            total-=nums[l];
            l++;
           }
           ans=ans+(r-l+1);
           r++;
        }
        return ans;
    }
}