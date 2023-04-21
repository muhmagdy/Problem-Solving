import java.util.Hashtable;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> table = new Hashtable<>(nums.length);
        int[] indices = new int[2];
        for(int i = 0; i < nums.length; i++){
            Integer index = table.get(target-nums[i]);
            if(index != null){
                indices[0] = i;
                indices[1] = index;
                break;
            }
            table.put(nums[i], i);
        }
        return indices;
    }
}