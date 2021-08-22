// 8/21/2021
/**
 * Definition for singly-linked li
 *     ListNode() {}
 *     ListNode(int val) { this.val st.
 * public class ListNode {
 *     int val;
 *     ListNode next;= val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // Approach 1: Find new head and tail in closed linked list
    // Close linked list off into a circular list, find the new head and tail, then close off the circular list
    // O(n)
    // O(1)
    public ListNode rotateRight(ListNode head, int k) {
        // edge case
        if (head == null)
            return null;
        if (head.next == null) 
            return head;
        
        // close linkedlist and find out the length
        ListNode oldTail = head;
        int n = 1;
        while (oldTail.next != null) {
            n++;
            oldTail = oldTail.next;
        }
        oldTail.next = head;
        
        // find new tail: (n - k%n - 1)th node
        // find new head: (n - k%n)th node
        // update linked list based on the new tail and head
        ListNode newTail = head;
        for (int i = 0; i < n - k%n - 1; i++) {
            newTail = newTail.next;
        }
        
        // find new head and break the ring
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}