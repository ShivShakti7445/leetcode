class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);map.put(1,-1);map.put(2,-1);
        int r=0;
        int ans=0;
        while(r<s.length()){
            char ch=s.charAt(r);
            map.put(ch-'a',r);
            if(map.get(0)!=-1&&map.get(1)!=-1&&map.get(2)!=-1){
                ans+=Math.min(map.get(0),Math.min(map.get(1),map.get(2)))+1;
            }
            r++;
        }
        return ans; 
    }
}