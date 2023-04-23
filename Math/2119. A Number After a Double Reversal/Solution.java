class Solution {
    public boolean isSameAfterReversals(int num) {
        return num == reverse(reverse(num));
    }
    
    public static int reverse(int x) {
        int res = 0;
        boolean negative = x < 0;
        if(negative)
            x =  x * -1;
        while(x > 0){
            res *= 10;
            res += x % 10;
            x /= 10;
        }
    
        if(negative)
            res *= -1;
        
        if(x > 0 && res < 0 || x < 0 && res > 0)
            return 0;
        
        return res;
    }
}
