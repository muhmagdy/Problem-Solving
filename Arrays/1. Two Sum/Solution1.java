import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        boolean exists = false;
        int[] indices = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(set.contains(target-nums[i])){
                indices[0] = i;
                exists = true;
                break;
            }
            set.add(nums[i]);
        }

        if(exists){
            int num = target - nums[indices[0]];
            for(int i = 0; i < indices[0]; i++){
                if(nums[i] == num){
                    indices[1] = i;
                    break;
                }
            }
        }

        return indices;
    }
}