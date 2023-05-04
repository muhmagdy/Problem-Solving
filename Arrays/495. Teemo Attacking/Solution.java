class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = duration;
        for(int i = 1; i < timeSeries.length; i++){
            res += duration;
            int diff = timeSeries[i] - timeSeries[i-1];
            if(diff < duration)
                res -= duration - diff;
        }
        return res;
    }
}