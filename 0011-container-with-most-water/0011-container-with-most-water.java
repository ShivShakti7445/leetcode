class Solution {
    public int maxArea(int[] height) {
       int n=height.length;
    //   Stack<Integer> st=new Stack<>();
    //   st.push(0);
       int maxarea=0;
    //   for (int i=0;i<n;i++){
    //    int length=(i-st.get(0));
    //    int ht=height[i];
    //    if(height[i]>height[st.get(0)]){
    //     maxarea=Math.max(length*height[st.get(0)],maxarea);
    //     st.pop();
    //     st.push(i);
    //    }
    //    else{
    //     maxarea=Math.max(length*ht,maxarea);
    //    }
    //   } 
    //   return maxarea;

    int l=0;
    int r=n-1;
    while(l<r){
     if(height[l]<=height[r]){
        maxarea=Math.max((r-l)*height[l],maxarea);
        l++;
     }
     else{
        maxarea=Math.max((r-l)*height[r],maxarea);
        r--;
     }
    }
    return maxarea;
    }
}