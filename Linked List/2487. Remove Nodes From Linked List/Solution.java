import java.util.Stack;

class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while(node != null){
            int size = stack.size();
            while(size > 0 && node.val > stack.peek().val){
                stack.pop();
                size--;
                if(stack.size > 0)
                    stack.peek().next = node;
                else head = node;
            }
            stack.push(node);
            node = node.next;
        }
        return head;
    }
}


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}