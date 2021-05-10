// May 10, 2021
// Interesting problem from recursion lesson card 

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
    // recursion
    // O(n) size of linked list
    // O(n) for recusion stack
    // Switching 2 nodes in the hlper function each recursion. Change the next pointer and connect to the next recursion.
    public ListNode swapPairs(ListNode head) {
        return swap(head);
    }
    
    public ListNode swap(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        
        firstNode.next = swap(secondNode.next);
        secondNode.next = firstNode;
        
        return secondNode;
    }
    
    // Iteration
    // O(n)
    // O(1)
    // Similar to recursion solution, just need to have a extra ListNode variable called prevNode to assign to after each iteration.
    public ListNode swapPairs(ListNode head) {
        
        // initialize dummy node for return purposes
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prevNode = dummy;
        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            
            //swap the nodes
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            
            // update prevNode and head for next iteration
            prevNode = firstNode;
            head = firstNode.next;
        }
        
        return dummy.next;
    }
}