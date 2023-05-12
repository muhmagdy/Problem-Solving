import java.util.Deque;

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode node = head;
        while(node != null){
            deque.add(node);
            node = node.next;
        }
        node = deque.pollFirst();
        node.next = deque.pollLast();
        node = node.next;
        while(!deque.isEmpty()){
            node.next = deque.pollFirst();
            node.next.next = deque.pollLast();
            node = node.next.next;
        }
        if(node != null) node.next = null;
    }
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

