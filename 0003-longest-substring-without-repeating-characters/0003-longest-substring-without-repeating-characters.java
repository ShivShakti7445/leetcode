import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1){
            return s.length();
        }

        int ans=0;
        int i=0,j=0;
        Set<Character> set=new HashSet<>();
        while(j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                ans=Math.max(ans,j-i+1);
                j++;
            }
            else{
                set.remove(s.charAt(i));
                i++;
            }
        }
    return ans;
    }
}
