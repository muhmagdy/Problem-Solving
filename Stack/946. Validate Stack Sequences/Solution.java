import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int poppedIndex = 0;
        for(int i = 0; i < pushed.length; i++){
            stack.add(pushed[i]);
            while(!stack.isEmpty() && poppedIndex < popped.length && stack.peek() == popped[poppedIndex]){
                poppedIndex++;
                stack.pop();
            }
        }
        return poppedIndex == popped.length;
    }
}