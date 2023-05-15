/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null, curr = head, temp = null;
        head = head.next;
        while(curr != null && curr.next != null){
            if(prev != null) prev.next = curr.next;
            temp = curr.next.next;
            curr.next.next = curr;
            curr.next = temp;
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}