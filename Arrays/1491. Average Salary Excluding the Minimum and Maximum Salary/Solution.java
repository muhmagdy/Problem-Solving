class Solution {
    public double average(int[] salary) {
        int min = Math.min(salary[0], salary[1]);
        int max = Math.max(salary[0], salary[1]);
        long sum = 0L;
        for(int i = 2; i < salary.length; i++){
            int sal = salary[i];
            if(sal < min){
                sum += min;
                min = sal;
            }else if(sal > max){
                sum += max;
                max = sal;
            }else
                sum += sal;
        }
        return sum / (double) (salary.length-2);
    }
}