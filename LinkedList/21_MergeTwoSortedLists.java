// 4/8/2021 7/10/2021
// tag: Linked List

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
     // Recursive:
    // O(n + m) 
    // O(n + m) store recursions stack
    // Two pointer approach and use recursion to continuously set the node's next pointers
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // base case if a list is fully sorted, then return the other list
        if (l1 == null) {
          return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        // pick the smaller node val and set the next to recur and return current
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    
    // Iteration
    //keep track of previous node and use it to add next
    // O(n + m) 
    // O(1)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // node prehead to keep track of head of list to return
        ListNode prehead = new ListNode(-1);
        // node prev to keep track of previous set node
        ListNode prev = prehead;
        
        // go through elements in both lists as long as none of the list is empty
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            }
            else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        
        // add to rest of the non-empty list
        prev.next = l1 == null ? l2:l1;
        
        return prehead.next;
    }
}