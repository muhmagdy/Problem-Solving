class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] longestCourse = new int[obstacles.length], longestSubseq = new int[obstacles.length];
        int longest = 0, l, r, mid;
        for(int i = 0; i < obstacles.length; i++){
            l = 0; 
            r = longest-1;
            while(l <= r){
                mid = l+(r-l)/2;
                if(longestSubseq[mid] > obstacles[i]) r = mid-1;
                else l = mid+1;
            }
            longestSubseq[l] = obstacles[i];
            if(l == longest) longest++;
            longestCourse[i] = l+1;
        }
        return longestCourse;
    }
}