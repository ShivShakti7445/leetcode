// class Solution {
//     public int subarraysWithKDistinct(int[] nums, int k) {
//          return (fun(nums,k)-fun(nums,k-1));
//     }
//     static int fun(int []nums,int k){
//         int n=nums.length;
//         HashMap<Integer,Integer> map=new HashMap<>();
//         int l=0;int r=0;
//         int ans=0;
//         while(r<n){
//             map.put(nums[r],map.getOrDefault(nums[r],0)+1);
//             while(map.size()>k && l<r){
//                 map.put(nums[l],map.get(nums[l])-1);
//                 if(map.get(nums[l])==0) map.remove(nums[l]);
//                 l++;
//             }
//             ans+=(r-l+1);
//             r++;
//         }
//         return ans;
//     }
// }

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    // Helper function to count subarrays with at most K distinct integers
    private int atMostK(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int count = 0;
        
        while (r < n) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            
            // Shrink the window if there are more than K distinct integers
            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
            }
            
            // All subarrays from l to r have at most k distinct integers
            count += (r - l + 1);
            r++;
        }
        
        return count;
    }
}

