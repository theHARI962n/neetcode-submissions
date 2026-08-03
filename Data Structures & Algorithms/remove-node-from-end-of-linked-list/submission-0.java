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


// brute force solution
class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Count the length
        int length = 0;
        ListNode curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        // Remove the head
        if (length == n) {
            return head.next;
        }

        // Go to the node before the one to remove
        curr = head;

        for (int i = 1; i < length - n; i++) {
            curr = curr.next;
        }

        // Delete
        curr.next = curr.next.next;

        return head;
    }
}