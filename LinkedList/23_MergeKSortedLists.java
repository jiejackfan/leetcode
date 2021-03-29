// March 27, 2021

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
    // brute force: O(nlogn) O(n)
    // Put all the numbers into an ArrayList. Sort the array list. Iterate through array list to create new linked list.
    public ListNode mergeKLists1(ListNode[] lists) {
        List<Integer> numbers = new ArrayList<Integer>();
        for(ListNode ln: lists) {
            while (ln != null) {
                numbers.add(ln.val);
                ln = ln.next;
            }
        }
        Collections.sort(numbers);
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int i: numbers){
            ListNode newNode = new ListNode(i);
            curr.next = newNode;
            curr = newNode;
        }
        curr.next = null;
        return dummy.next;
    }
    
    // Merge w/ Divide and Conquer 
    // O(nlogk) where k=# of linked lists, n=value/node , O(1)
    // Merge the array of lists 2 by 2. And repeat until only there is only 1 list
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        
        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i+interval < lists.length; i=i+interval*2) {
                lists[i] = merge2Lists(lists[i], lists[i+interval]);
            }
            interval *= 2;
        }
               
        return lists[0];
    }
    
    // Helper function to merge 2 lists in order.
    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
            }
        }
        if (l1 == null) {
            curr.next = l2;
        } else if (l2 == null) {
            curr.next = l1;
        }
        
        return dummy.next;
    }
}