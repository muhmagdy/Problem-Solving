import java.util.LinkedList;
import java.util.Deque;
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return head;
        Deque<ListNode> deque = new LinkedList<>();
        ListNode node = head;
        int n = 0;
        while(node != null){
            deque.add(node);
            node = node.next;
            n++;
        }
        for(int i = 0; i < k%n; i++){
            ListNode newHead = deque.pollLast();
            newHead.next = head;
            head = newHead;
            deque.addFirst(head);  
        }
        deque.peekLast().next = null;
        return head;
    }
}


// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}