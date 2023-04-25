import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            Integer f = frequencies.get(nums[i]);
            if(f == null)
                frequencies.put(nums[i], 1);
            else
                frequencies.put(nums[i], f+1);
        }
        int maj = nums.length/2;
        for(Map.Entry<Integer, Integer> freq: frequencies.entrySet()){
            if(freq.getValue() > maj)
                return freq.getKey();
        }
        return Integer.MIN_VALUE;
    }
}