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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode firstPtr = dummy;
        ListNode secondPtr = dummy;

        // Move second pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            secondPtr = secondPtr.next;
        }

        // Move both pointers until second reaches end
        while (secondPtr != null) {
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }

        // Remove the nth node
        firstPtr.next = firstPtr.next.next;

        return dummy.next;
    }
}