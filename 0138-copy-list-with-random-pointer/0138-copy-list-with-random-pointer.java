/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> hm = new HashMap<>();
    public Node copyRandomList(Node head) {
        Node curr = head;
        while(curr != null){
            hm.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        Node currNew = head;
        while(currNew != null){
            Node node = hm.get(currNew);
            node.next = hm.get(currNew.next);
            node.random = hm.get(currNew.random);
            currNew = currNew.next;
        }
        return hm.get(head);
    }
}