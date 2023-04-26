import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens){
            char charachter = token.charAt(0);
            if(token.length() == 1 && charachter == '+'){
                stack.push(stack.pop() + stack.pop());
            }
            else if(token.length() == 1 && charachter == '-'){
                int y = stack.pop();
                stack.push(stack.pop() - y);
            }
            else if(charachter == '*'){
                stack.push(stack.pop() * stack.pop());
            }
            else if(charachter == '/'){
                    int y = stack.pop();
                    stack.push(stack.pop() / y);
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}