// 7/10/2021

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
    // Approach 1: find middle, reverse second half and merge two list 
    // O(n)
    public void reorderList(ListNode head) {
        if (head == null) return;
        
        // find middle node
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // now middle node is on slow, reverse the list starting from middle to the last
        ListNode prev = null, cur = slow, tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        
        // now prev contains the reversed head of the second part of list
        // use head and prev to do merge of the two lists
        ListNode first = head, second = prev;
        // be careful that last node in first's list is connected to last node in second's list, thats why this iteration will work.
        // when there are even # of elements, we will use this property, we don't visit the last node in second's list
        // when there are odd # of elements, we will visit every node
        while (second.next != null) {
            // 1 iteration changes first.next and second.next
            
            // change first node's next to second
            tmp = first.next;
            first.next = second;
            first = tmp;
            
            // change second node's next to first.next
            tmp = second.next;
            second.next =first;
            second = tmp;
        }
        
        return;
        
    }
}