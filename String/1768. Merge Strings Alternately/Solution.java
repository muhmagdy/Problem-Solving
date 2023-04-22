class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder answer = new StringBuilder();
        int pos1 = 0, pos2 = 0;
        int size1 = word1.length(), size2 = word2.length();
        
        while(pos1 < size1 || pos2 < size2){
            if(pos1 < size1){
                answer.append(word1.charAt(pos1));
                pos1++;
            }else{
                answer.append(word2.substring(pos2, size2));
                pos2 = size2;
            }

            if(pos2 < size2){
                answer.append(word2.charAt(pos2));
                pos2++;
            }else{
                answer.append(word1.substring(pos1, size1));
                pos1 = size1;
            }
        }

        return answer.toString();
    }
}