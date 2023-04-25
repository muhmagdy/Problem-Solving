class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] exists = new boolean[200];
        int maxLength = 0, length = 0;
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            int letter = s.charAt(i);
            if(exists[letter]){
                if(length > maxLength)
                    maxLength = length;
                i = j++;
                length = 0;
                exists = new boolean[200];
                continue;
            }
            exists[letter] = true;
            length++;
        }
        return Math.max(length,maxLength);
    }
}