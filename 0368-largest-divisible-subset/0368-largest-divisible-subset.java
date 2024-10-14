class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
     int n=nums.length;
     Arrays.sort(nums);
     int dp[]=new int [n];
     Arrays.fill(dp,1);
     int hash[]=new int[n];

     for(int i=1;i<n;i++){
        hash[i]=i;
        for(int j=0;j<=i-1;j++){
            if(nums[i]%nums[j]==0&&dp[i]<dp[j]+1){
                dp[i]=1+dp[j];
                hash[i]=j;
            }
        }
     }
     int max=-1;
     int ind=-1;
     for(int i=0;i<n;i++){
        if(dp[i]>max){
            max=dp[i];
            ind=i;
        }
     }
    ArrayList<Integer>list=new ArrayList<>(max);
     list.add(nums[ind]);
     while(hash[ind]!=ind){
        ind=hash[ind];
        list.add(nums[ind]);
     }
     
     Collections.reverse(list);
     return list;
    }
}