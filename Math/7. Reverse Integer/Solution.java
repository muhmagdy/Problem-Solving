class Solution {
    public int reverse(int x) {
        long res = 0;
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
        
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return 0;

        return (int) res;
    }
}