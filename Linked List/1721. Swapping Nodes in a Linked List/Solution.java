class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode prev = null, curr = head, front = null, frontPrev = null, forward = null;
        // Find k from front
        for(int i = 1; i < k; i++){
            prev = curr;
            curr = curr.next;
        }
        front = curr;
        frontPrev = prev;
        forward = curr;
        prev = null;
        curr = head;
        // find k from back
        while(forward.next != null){
            forward = forward.next;
            prev = curr;
            curr = curr.next;
        }
        if(frontPrev != null) frontPrev.next = curr;
        if(prev != null) prev.next = front;
        ListNode temp = front.next;
        front.next = curr.next;
        curr.next = temp;
        if(front.next == null) head = curr;
        else if(curr.next == null) head = front;
        return head;
    }
}

//Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}