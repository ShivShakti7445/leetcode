class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int maxsum=0;
        int lsum=0;
        int rsum=0;
        int rind=n-1;
        for(int lind=0;lind<k;lind++){
            lsum+=cardPoints[lind];
        }
        maxsum=Math.max(maxsum,lsum);

        for(int lind =k-1;lind>=0;lind--){
            lsum-=cardPoints[lind];
            rsum+=cardPoints[rind];
            maxsum=Math.max(maxsum,lsum+rsum);
            rind--;
        }
        return maxsum;
    }
}