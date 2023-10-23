class Solution {
    public int minOperations(String[] logs) {
        int stackLength = 0;
        for(String log: logs){
            if(log.equals("../")){
                if(stackLength > 0)
                    stackLength--;
            }
            else if (log.equals("./"))
                continue;
            else
                stackLength++;
        }
        return stackLength;
    }
}
