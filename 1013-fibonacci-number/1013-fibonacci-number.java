class Solution {
    public int fib(int n) {
       return fabo(n); 
    }
    static int fabo(int n){
            if(n>1) return(fabo(n-1)+fabo(n-2));
            return n;
    }
}