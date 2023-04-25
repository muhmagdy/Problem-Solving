class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        StringBuilder saying = new StringBuilder();
        String oldSaying = countAndSay(n-1);
        int count = 0;
        char digit = 0;
        for(int i = 0; i < oldSaying.length(); i++){
            if(oldSaying.charAt(i) != digit){
                if(count != 0){
                    saying.append(count);
                    saying.append(digit);
                }
                count = 1;
                digit = oldSaying.charAt(i);
            }
            else count++;
        }
        saying.append(count);
        saying.append(digit);
        return saying.toString();
    }
}