class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
      return (fun(nums,k)- fun(nums,k-1));
    }
    static int fun(int nums[],int k){
       int ans=0;
       int goal=0;
       int l=0;int r=0;    
       while(r<nums.length){
        goal+=nums[r]%2;
        while(goal>k){
            goal-=nums[l]%2;
            l++;
        }
        ans+=r-l+1;
        r++;
       }
       return ans;
    }
}