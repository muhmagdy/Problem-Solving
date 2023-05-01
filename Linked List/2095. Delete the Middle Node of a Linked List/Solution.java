class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode middlePrev = null, middle = head, node = head;
        int count = 0;
        while(node != null){
            node = node.next;
            if(++count % 2 == 0){
                middlePrev = middle;
                middle = middle.next;
            }
        }
        if(middlePrev == null)
            head = null;
        else
            middlePrev.next = middle.next;
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
