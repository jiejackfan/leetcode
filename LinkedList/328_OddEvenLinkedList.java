// 9/4/2021
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
    // Approach 1: Two Linked List
    // O(n) O(1)
    // Keep track of 2 linked lists with heads and tails
    // One even list and one odd list. Manipulate their next relationships to create 2 different linkedlist
    // join the lists at the end.
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        
        ListNode odd = head, even = head.next, evenHead = even;
        
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        
        return head;
    }
}