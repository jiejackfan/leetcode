// April 8, 2021

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
    // Iterative Two Pointer
    // O(n) O(n)
    // Put all nodes into an ArrayList, set two pointers, one at each end 
    // and check if they are eqaul as they move closer.
    public boolean isPalindrome(ListNode head) {
        ArrayList<ListNode> vals = new ArrayList<>();
        
        while (head != null) {
            vals.add(head);
            head = head.next;
        }
        
        int left = 0;
        int right = vals.size() - 1;
        
        while (left <= right) {
            if (vals.get(left).val != vals.get(right).val) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    
    // Recursive
    // O(n), O(n)
    // Recur to the last node, and remember the first node as global variable
    // Start returning from the back of array and compare value.
    private ListNode firstPointer;
        
    private boolean recursiveCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursiveCheck(currentNode.next)) return false;
            if (currentNode.val != firstPointer.val) return false;
            firstPointer = firstPointer.next;
        }
        return true;
    }
    public boolean isPalindrome(ListNode head) {
        firstPointer = head;
        return recursiveCheck(firstPointer);
    }
}