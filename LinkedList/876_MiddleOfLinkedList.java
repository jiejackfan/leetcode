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
    
    // Fast & slow pointer
    // have two pointers move together, 1 at twice the speed of the other one.
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head, p2 = head;
        
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        return p1;
    }
}