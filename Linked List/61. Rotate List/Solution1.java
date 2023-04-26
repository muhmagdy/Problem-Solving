class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode tail = head;
        int n = 0;
        while(tail.next != null){
            tail = tail.next;
            n++;
        }

        k = k%(n+1);

        if(k == 0) return head;

        ListNode newTail = head;
        for(int i = 0; i < n-k; i++)
            newTail = newTail.next;
        tail.next = head;
        head = newTail.next;
        newTail.next = null;
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