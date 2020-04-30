/*
//Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
*/

class Solution {
    // given listNode has no head node, the first node will contain the least significant
    //  digit.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // set a variable to keep track of the two nodes
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        int carry = 0;

        // setup new linked list to be returned as an answer
        ListNode dummyHead = new ListNode(0);
        ListNode result = dummyHead;

        // while there are still digits in any of the list not yet processed
        while (tmp1 != null || tmp2 != null) {
            int val1 = tmp1==null ? 0 : tmp1.val;
            int val2 = tmp2==null ? 0 : tmp2.val;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            result.next = new ListNode(sum % 10);
            result = result.next;

            if (tmp1 != null) {
                tmp1 = tmp1.next;
            }
            if (tmp2 != null) {
                tmp2 = tmp2.next;
            }
        }

        //after the last iteration, check if we need one more digit
        if (carry == 1) {
            result.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}
