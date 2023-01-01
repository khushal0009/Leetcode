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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null){
            return null;
        }
        ListNode prev=null;
        ListNode cur=head;
        
        while(left>1){
            prev=cur;
            cur=cur.next;
            left--;
            right--;
        }
        ListNode connection=prev;
        ListNode tail=cur;
        
        while(right>0){
            ListNode nex=cur.next;
            cur.next=prev;
            prev=cur;
            cur=nex;
            right--;
        }
        if(connection!=null){
            connection.next=prev;
        }else{
            head=prev;
        }
        tail.next=cur;
        return head;
        
    }
}