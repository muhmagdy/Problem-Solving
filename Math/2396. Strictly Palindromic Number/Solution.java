class Solution {
    public boolean isStrictlyPalindromic(int n) {
        StringBuilder builder = new StringBuilder();
        for(int b = 2; b <= n-2; b++){
            builder.setLength(0);
            int temp = n;
            while(temp > 0){
                builder.insert(0, temp%b);
                temp /= b;
            }
            if(!isPlaindromic(builder)) return false;
        }
        return true;
    }
    
    private boolean isPlaindromic(StringBuilder s){
        int len = s.length();
        for(int i = 0; i < len/2; i++){
            if(s.charAt(i) != s.charAt(len-i-1)) return false;
        }
        return true;
    }
}