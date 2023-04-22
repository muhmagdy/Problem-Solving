import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> haveGreatest = new ArrayList<>(candies.length);
        int originalGreatest = 0;
        for(int candy: candies){
            if(candy > originalGreatest)
                originalGreatest = candy;
        }

        for(int candy: candies){
            if(candy + extraCandies >= originalGreatest)
                haveGreatest.add(true);
            else
                haveGreatest.add(false);
        }

        return haveGreatest;
    }
}