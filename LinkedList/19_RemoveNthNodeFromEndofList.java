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
    
    // One Pass:
    // Two pointers, one to find the end of list one to find the node to remove. 
    // They differ by a set length of n.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        
        for (int i = 0; i < n+1; i++) {
            first = first.next;
        }
        
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        second.next = second.next.next;
        
        return dummy.next;
    }
}