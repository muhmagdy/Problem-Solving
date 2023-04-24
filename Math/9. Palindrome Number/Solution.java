class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int temp = x;
        int pal = 0;
        while(temp > 0){
            pal *= 10;
            pal += temp % 10;
            temp /= 10;
        }
        return pal == x;
    }
}