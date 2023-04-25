class Solution {
    public int partitionString(String s) {
        boolean[] exists = new boolean[26];
        int partitions = 1;
        for(int i = 0; i < s.length(); i++){
            int letter = s.charAt(i)-97;
            if(exists[letter]){
                partitions++;
                exists = new boolean[26];
            }
            exists[letter] = true;
        }
        return partitions;
    }
}