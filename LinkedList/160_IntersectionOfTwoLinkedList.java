//8/16/2021

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // Approach 1: Brute force 
    // O(a * b)
    // O(1)
    // iterate through list A and find if it matches with any in list B
    // Slow (809 ms) approach not viable
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null) {
            ListNode pB = headB;
            
            // check headA with every node in B
            while (pB != null) {
                if (headA == pB) {
                    return headA;
                }
                pB = pB.next;
            }
            
            headA = headA.next;
        }
        return null;
    }
    
    // Approach 2: HashTable (sufficient for interview)
    // O(a + b)
    // O(b)
    // store list B in a hashset, iterate through A to find if there is an intersection
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // init hashset
        HashSet<ListNode> nodesInB = new HashSet<ListNode>();
        
        // add all b to hashset
        while (headB != null) {
            nodesInB.add(headB);
            headB = headB.next;
        }
        
        // iterate through A to check if any intersection
        while (headA != null) {
            if (nodesInB.contains(headA))
                return headA;
            headA = headA.next;
        }
        return null;
    }
    
    // Approach 3: Two Pointer
    // O(a + b)
    // O(1)
    // Pointer 1 does a + c + b loop and pointer 2 does b + c + a loop
    // they will eventualy converge on to the intersection point
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        
        while (pA != pB) {
            pA = pA == null? headB : pA.next;
            pB = pB == null? headA : pB.next;
        }
        return pA;
    }
}