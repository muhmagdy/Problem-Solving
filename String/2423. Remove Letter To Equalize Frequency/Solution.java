class Solution {
    public boolean equalFrequency(String word) {
        char[] freq = new char[26];
        for(int i = 0; i < word.length(); i++){
            int c = word.charAt(i)-'a';
            freq[c]++;
        }
        for(int i = 0; i < 26; i++){
            if(freq[i] == 0)
                continue;
            freq[i]--;
            boolean isEqual = true;
            for(int j = 0; j < 26; j++){
                if(freq[j] == 0)
                    continue;
                for(int k = j+1; k < 26; k++){
                    if(freq[k] == 0)
                        continue;
                    // System.out.println("      j = " + j +             ",       k = " + k);
                    // System.out.println("freq[j] = " + (int) freq[j] + ", freq[k] = " + (int) freq[k]);
                    if(freq[j] != freq[k]){
                        isEqual = false;
                        break;
                    }
                }
                if(!isEqual)
                    break;
            }
            if(isEqual)
                return true;
            freq[i]++;
        }
        return false;
    }
}