class Solution {
    public List<String> stringSequence(String target) {
          List<String> result = new ArrayList<>();
        StringBuilder currString = new StringBuilder();
        
        for (char c : target.toCharArray()) {
            currString.append('a'); 
            result.add(currString.toString());
            
            while (currString.charAt(currString.length() - 1) != c) {
                char lastChar = currString.charAt(currString.length() - 1);
                currString.setCharAt(currString.length() - 1, (char)(lastChar + 1));
                result.add(currString.toString());
            }
        }
        
        return result;
    }
}