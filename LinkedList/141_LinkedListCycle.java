// April 08 2021

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // Hashtable
    // O(n), O(n)
    // Use while loop to iterate through all list, and add seen nodes into
    // the hashtable. If we encounter a duplicate visit, we know there is a cycle
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> nodeSeen = new HashSet<>();
        
        while (head != null) {
            if (nodeSeen.contains(head)) return true;
            else {
                nodeSeen.add(head);
            }
            head = head.next;
        }
        
        return false;
    }
    
    // Floyd's Cycle
    // O(n), O(1)
    // Have two pointer traverse the linked list from start. The faster node will jump a node
    // every iteration and slow node will move one node at a time. If they eventually meet
    // then the list is cyclic.
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}