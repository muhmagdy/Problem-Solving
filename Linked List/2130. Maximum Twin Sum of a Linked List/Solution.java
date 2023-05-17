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
    public int pairSum(ListNode head) {
        // Get to the middle
        ListNode fast = head, slow = head;
        while(fast != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse linked list
        ListNode prev = null, temp = null;
        while(slow != null){
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            if(temp == null) break;
            slow = temp;
        }
        // Iterate and add
        int maxSum = 0;
        while(slow != null){
            maxSum = Math.max(maxSum, head.val + slow.val);
            head = head.next;
            slow = slow.next;
        }
        return maxSum;
    }
}