// April 6, 2021
// May 11, 2021 in recursion lesson stack 1
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
    // O(n) size of linked list
    // O(1) no extra storage space
    // Go through the list from head to tail, switching next pointers one by one. Saves the previous node so current node can have a target for its next pointer.
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
    // O(n)
    // O(n) recursion stack
    // Recur to the last item, work backwards. Always return the last head so at the end we can return the last item. Change the next
    // pointers accordingly. This works without using a helper function.
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // recur and keep track of the last node, which is also the new head
        ListNode finalNode = reverseList(head.next);

        // change next pointers
        head.next.next = head;
        head.next = null;

        return finalNode;
    }
}