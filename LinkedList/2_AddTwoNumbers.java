// March 21, 2021

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
    // Need to iterate two ListNodes one by one and add them along the way.
    // Creat a dummy head to start the answer linked list.
    // As we iterate, we check if the node is null, computer the sum & carry, and 
    // move the iterating pointer to the next node.
    // Make sure to check if the 
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummyHead;
        int carry = 0;
        while (p!=null || q!=null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        
        if (carry == 1) {
            curr.next = new ListNode(1);
        }
        
        return dummyHead.next;
        
    }
}