class Solution {
    public int minPartitions(String n) {
        int maxDigit = 0;
        for(int i = 0; i < n.length(); i++){
            char digit = n.charAt(i) - '0';
            if(digit > maxDigit)
                maxDigit = digit;
            if(digit == 9)
                return 9;
        }
        return maxDigit;
    }
}