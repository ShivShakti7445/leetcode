class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int dp1[] = new int[n]; // Longest Increasing Subsequence
        Arrays.fill(dp1, 1);
        int count[]=new int[n];
        Arrays.fill(count, 1);

        int maxi=1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]&& 1+dp1[j]>dp1[i]) {
                    dp1[i] = Math.max(dp1[i], 1 + dp1[j]);
                    maxi=Math.max(maxi,dp1[i]);
                    count[i]=count[j];
                }
                else if(nums[i] > nums[j]&& 1+dp1[j]==dp1[i]){
                    count[i]+=count[j];
                }
            }
        }

        int ans=0;
        for(int i=0;i<n;i++){
            if(dp1[i]==maxi) ans+=count[i];
        }
        return ans;   
    }
}