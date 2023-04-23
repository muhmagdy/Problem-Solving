class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[265];
        for(int i = 0; i < text.length(); i++){
            freq[text.charAt(i)]++;
        }
        freq['l'] /= 2;
        freq['o'] /= 2;
        
        int min = Integer.MAX_VALUE;
        for(char letter: new char[]{'b', 'a', 'l', 'o', 'n'}){
            if(freq[letter] < min){
                min = freq[letter];
            }
        }

        return min;
    }
}