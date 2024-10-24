class Solution {
    public boolean isPalindrome(int x) {
      int p=0;
      int m=x;
      while(x>0){
        int rem=x%10;
        x=x/10;
        p=p*10+rem;
      }
      return p==m?true:false;
    }
}