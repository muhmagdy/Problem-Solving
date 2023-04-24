class Solution {
    public boolean validPalindrome(String s) {
        return validPalindrome(s, false, 0, s.length()-1);
    }

    public static boolean validPalindrome(String s, boolean oneCharFound, int lPtr, int rPtr){
        int n = s.length();
        while(rPtr > lPtr){
            char lChar = s.charAt(lPtr);
            char rChar = s.charAt(rPtr);
            if(lChar == rChar){
                lPtr++;
                rPtr--;
            }
            else{
                if(oneCharFound)
                    return false;
                if(lPtr+1 >= n)
                    return validPalindrome(s, true, lPtr, rPtr-1);
                else if(rPtr - 1 <= 0)
                    return validPalindrome(s, true, lPtr+1, rPtr);
                return 
                    validPalindrome(s, true, lPtr, rPtr-1) || 
                    validPalindrome(s, true, lPtr+1, rPtr); 
            }
        }
        return true;
    }
}