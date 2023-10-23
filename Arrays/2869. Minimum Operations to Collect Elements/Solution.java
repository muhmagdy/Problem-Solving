class Solution {
    public int minOperations(List<Integer> nums, int k) {
        Set<Integer> set = new HashSet<>();
        int n = nums.size();
        int operations = 0;
        int sum = (k * (k+1))/2;
        for(int i = n-1; i >= 0 && sum > 0; i--){
            int num = nums.get(i);
            if(num <= k && !set.contains(num)){
                sum -= num;
                set.add(num);
            }
            operations++;
        }
        return operations;
    }
}