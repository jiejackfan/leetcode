// April 6 2021
// tag: linked list 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // Traditional method is find previous node, and point prev node's next pointer to the node after current node
    // Because we are not given the prev node, we will copy next node to this node and delete the next node
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}