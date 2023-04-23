class Solution {
    public int myAtoi(String s) {
        int result = 0;
        int i = 0;

        // Ignore white spaces
        while(i < s.length() && s.charAt(i) == ' ')
            i++;

        // Read sign
        boolean negative = false;
        if(i < s.length()){
            if(s.charAt(i) == '+')
                i++;
            else if(s.charAt(i) == '-'){
                negative = true;
                i++;
            }
        }
        
        // Read numbers
        boolean overflow = false;
        int startingIndex = i;
        while(i < s.length()){
            char digit = s.charAt(i);
            if(!Character.isDigit(digit))
                break;
            // Detect Overflow
            if(i - startingIndex == 9){
                if((result > Integer.MAX_VALUE/10) || (result == Integer.MAX_VALUE/10) && (negative && digit-48 > 8 || !negative && digit-48 > 7)){
                    overflow = true;
                    break;
                }
            }else if(i - startingIndex > 9){
                overflow = true;
                break;
            }
            result *= 10;
            result += digit - 48;
            if(startingIndex == i && result == 0)
                startingIndex++;
            i++;
        }

        if(negative)
            result *= -1;
        
        if(overflow && !negative)
            result = Integer.MAX_VALUE;
        else if(overflow && negative)
            result = Integer.MIN_VALUE;
        
        return result;
    }
}