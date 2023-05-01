class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        for(int i = 0; i < n; i++)
            node = node.next;
        ListNode nPrev = null, nthNode = head;
        while(node != null){
            node = node.next;
            nPrev = nthNode;
            nthNode = nthNode.next;
        }
        if(nPrev == null) return head.next;
        nPrev.next = nthNode.next;
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