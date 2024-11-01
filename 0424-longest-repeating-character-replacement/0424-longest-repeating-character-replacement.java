class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int ans=0;
        int maxfre=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int r=0;r<s.length();r++){
           char ch=s.charAt(r);
           map.put(ch,map.getOrDefault(ch,0)+1);
           // no. of compersion need
           maxfre=Math.max(maxfre,map.get(ch));
           if((r-l+1)-maxfre>k){
                 map.put(s.charAt(l),map.get(s.charAt(l))-1);
                 l++;
           }
           ans=Math.max(ans,(r-l+1));
        }
        return ans;
    }
}
