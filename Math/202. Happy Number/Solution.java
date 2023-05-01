import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while(n != 1){
            int x = 0;
            while(n > 0){
                int digit = n % 10;
                x += digit * digit;
                n /= 10;
            }
            n = x;
            if(seen.contains(n))
                return false;
            seen.add(n);
        }
        return true;
    }
}