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
        
        ListNode slow = head, fast = head;
        
        // move fast n position forwards
        while(n != 0){
            fast = fast.next;
            n--;
        }
        
        // now move slow and fast both till fast not reach to end of LL
        while(fast != null && fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        // if fast is null, its mean we want to delete head node
        if(fast == null) return head.next;
        
        // remove node
        slow.next = slow.next.next;
        
        return head;
    }
}

