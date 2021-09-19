//April 5, 2021
// tag: Linked List, Two Pass, One Pass
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
    // Two Pass:
    // Find the node to remove first by iterating through the linked list
    // then iterate again to 
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode first = head;
        
        int length = 0;
        while (first != null) {
            length++;
            first = first.next;
        }
        
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        
        first.next = first.next.next;
        return dummy.next;
    }
    
    // **Approach 2: Two Pointers 
    // Maintain 2 pointers, one goes thru all element, the other one has a delay of n+1 steps
    // when the faster one reaches the end, the slower one is the element to remove
    // Use dummy node for LinkedList to avoid corner/edge cases
    // O(n) O)(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // remove current slow element
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}