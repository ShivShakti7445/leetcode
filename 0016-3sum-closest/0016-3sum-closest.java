class Solution {
    public int threeSumClosest(int[] nums, int target) {
       int n=nums.length;
       Arrays.sort(nums);
     
       int closest=nums[0]+nums[1]+nums[2];
       for(int i=0;i<=n-3;i++){
        int l=i+1;int r=n-1;
        while(l<r){
            int currsum=nums[l]+nums[r]+nums[i];
            if(currsum==target) return target;
            if(Math.abs(currsum-target)<Math.abs(closest-target)){
                closest=currsum;
            }
            if(currsum>target) r--;
            else l++;
        }
       }
       return closest;
    }
}