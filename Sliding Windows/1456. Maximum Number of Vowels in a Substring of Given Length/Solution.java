class Solution {
    public int maxVowels(String s, int k) {
        int max = 0;
        for(int i = 0; i < k; i++)
            if(isVowel(s.charAt(i))) max++;
        if(max == k) return max;
        int v = max, size = s.length();
        for(int i = k; i < size; i++){
            if(isVowel(s.charAt(i-k)))  
                v--;
            if(isVowel(s.charAt(i)))    
                v++;
            max = Math.max(max, v);
        }
        return max;
    }
    
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}