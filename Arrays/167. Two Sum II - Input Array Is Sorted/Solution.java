class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int first = 0;
        int last = numbers.length-1;
        
        int[] indices = {-1,-1};

        while(first != last){
            int sum = numbers[first] + numbers[last];
            if(sum == target){
                indices = new int[]{first+1, last+1};
                break;
            }
            else if (sum > target){
                last--;
            }
            else{
                first++;
            }
        }
        return indices;
    }
}