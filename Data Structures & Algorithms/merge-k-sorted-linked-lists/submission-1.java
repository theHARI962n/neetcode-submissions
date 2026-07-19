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

    public ListNode mergeKLists(ListNode[] lists) {

        // Min Heap
        PriorityQueue<ListNode> pq =
            new PriorityQueue<>(
                (a, b) -> Integer.compare(a.val, b.val)
            );

        // Step 1:
        // Add the first node of every linked list
        for (ListNode head : lists) {

            if (head != null) {
                pq.offer(head);
            }
        }

        // Dummy node to simplify building the result
        ListNode dummy = new ListNode(-1);

        // Tail points to the last node of our result
        ListNode tail = dummy;

        // Step 2:
        // Process all nodes
        while (!pq.isEmpty()) {

            // Get smallest node
            ListNode current = pq.poll();

            // Attach it to result
            tail.next = current;

            // Move tail forward
            tail = tail.next;

            // Add next node from the same list
            if (current.next != null) {
                pq.offer(current.next);
            }
        }

        // Skip dummy node
        return dummy.next;
    }
}