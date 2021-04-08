// April 6, 2021
// tags: Linked List, Iterative, Recursion

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
    // Iterative
    // Go through the list from head to tail
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null){
            // save next node
            ListNode next = curr.next;
            
            // change current node's pointer
            curr.next = prev;
            
            // prep for next iteration
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    // Recursive
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}