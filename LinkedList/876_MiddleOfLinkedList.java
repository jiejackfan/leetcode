// 07/05/2021
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
    // My solution: two loop: count elements through one loop, find mid through another
    // O(2n)
    // O(1)
//     public ListNode middleNode(ListNode head) {
//         // find linked list length
//         int len = 0;
//         ListNode head2 = head;
//         while(head != null) {
//             len++;
//             head = head.next;
//         }
//         System.out.println(len);
//         int mid = len / 2;
//         System.out.println(mid);
//         while (mid > 0) {
//             head2 = head2.next;
//             mid--;
//             System.out.println(mid);
//         }
        
//         return head2;
//     }
    
    // Approach 1: Two pointers
    // Maintain 2 pointers, fast runs twice as fast as the slow
    // when the fast reaches null, we know the slow is at the middle position
    // Using dummy node here requires a corner case if statement
    // O(n) O(1)
    public ListNode middleNode(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // edge case
        if (fast != null) 
            slow = slow.next;
        
        return slow;
    }
}