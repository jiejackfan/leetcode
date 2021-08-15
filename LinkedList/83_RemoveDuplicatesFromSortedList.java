//8/14/2021

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
    
    // Approach 1: modify next pointer
    // Loop through each node, and switch next pointer later node if the current next pointer contains the same value
    // O(n)
    // O(1)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        
        while (cur != null && cur.next != null) {
            // if the next node contains the same value, we skip next node
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            // else  we move on to the next number
            else {
                cur = cur.next;
            }
        }
        
        return head;
    }
}