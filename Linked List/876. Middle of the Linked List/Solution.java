class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode middle = head;
        int count = 0;
        while(head != null){
            head = head.next;
            if(++count % 2 == 0)
                middle = middle.next;
        }
        return middle;
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