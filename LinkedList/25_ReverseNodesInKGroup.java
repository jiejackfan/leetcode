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
    // Approach 1 : Recursion (not constant space)
    // Recursively sort k nodes at a time
    // O(n) O(n/k)
    public ListNode reverseLinkedList(ListNode head, int k) {
        // Reverse k nodes of the given linkd list
        // Given list will have at least k nodes
        
        ListNode new_head = null;
        ListNode ptr = head;
        
        while (k > 0) {
            // keep track of next node to process
            ListNode next_node = ptr.next;
            
            // insert the "ptr" node to the beginning of the reversed list
            ptr.next = new_head;
            new_head = ptr;
            
            // move to next ptr and k--
            ptr = next_node;
            k--;
        }
        
        return new_head;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode ptr = head;
        
        // First check if there are at least k nodes
        // left in our linked list
        while (count < k && ptr != null) {
            ptr = ptr.next;
            count++;
        }
        
        // if we have k nodes, reverse them. 
        // call this main func again to reverse next k nodes
        if (count == k) {
            // reverse first k nodes, get the reversed list's head
            ListNode reversedHead = this.reverseLinkedList(head, k);
            
            // now recur on the remaining list
            // original head now is the last elemen of current list, so next is the
            // reverseHead of the next k list
            head.next = this.reverseKGroup(ptr, k);
            return reversedHead;
        }
        
        // if we don't have k nodes left, we just return head
        return head;
    }
    
    // Approach 2 : Iterative O(1) Space
    // O(n) O(1)
    // 2 more var to keep track of when doing iteration
    // 1. head ~ alway point to original head of next set of k nodes
    // 2. revHead ~ tail node of original set of k nodes. New head node for list
    // 3. ktail ~ tail node of previous set of nodes after reversal
    // 4. newHead ~ head of final list we need to return
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head;
        ListNode ktail = null;
        
        // head of final modified linked list
        ListNode new_head = null;
        
        // keep going until no nodes
        while (ptr != null) {
            int count = 0;
            
            // start counting nodes from the head
            ptr = head;
            
            // find the head of next k nodes
            while (count < k && ptr != null) {
                ptr = ptr.next;
                count += 1;
            }
            
            // if we counted k nodes, reverse them
            if (count == k) {
                // reverse k nodes and get new head
                ListNode revHead = this.reverseLinkedList(head, k);
                
                // new head is head of final
                if (new_head == null)
                    new_head = revHead;
                
                // ktail is the tail of previous block of reversed k nodes
                if (ktail != null) 
                    ktail.next = revHead;
                
                ktail = head;
                head = ptr;
            }
        }
        
        if (ktail != null) 
            ktail.next = head;
        
        return new_head == null ? head : new_head;
    }
}