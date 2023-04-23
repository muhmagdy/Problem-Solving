
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode();
        ListNode cur = sum;
        ListNode prev = null;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int res = 0;
            if(l1 == null && l2 != null){
                System.out.println(1);
                res = l2.val + carry;
                l2 = l2.next;
            } else if(l1 != null && l2 == null){
                res = l1.val + carry;
                l1 = l1.next;
            } else if(l1 != null && l2 != null){
                res = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else {
                res = carry;
            }
            cur.val =  res % 10;
            carry = res / 10;
            cur.next = new ListNode();
            prev = cur;
            cur = cur.next;
        }
        prev.next = null;
        return sum;
    }
}