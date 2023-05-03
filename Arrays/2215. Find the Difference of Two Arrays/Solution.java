import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        for(int num: nums1)
            nums1Set.add(num);   
        Set<Integer> nums1Distinct = new HashSet<>(nums1Set);
        Set<Integer> nums2Distinct = new HashSet<>();
        for(int num: nums2){
            if(nums1Set.contains(num))
                nums1Distinct.remove(num);
            else if(!nums2Distinct.contains(num))
                nums2Distinct.add(num);
        }
        List<List<Integer>> result = new LinkedList<>();
        result.add(new ArrayList(nums1Distinct));
        result.add(new ArrayList(nums2Distinct));
        return result;
    }
}