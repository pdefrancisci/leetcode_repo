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
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Map<Node,Node> oldToNew = new HashMap<>();
        Node ret = new Node(head.val);
        Node prevN = ret;
        Node prevO = head;
        oldToNew.put(prevO,ret);
        while(prevO.next!=null){
            Node nextN = new Node(prevO.next.val);
            prevN.next = nextN;
            oldToNew.put(prevO.next,nextN);
            prevO=prevO.next;
            prevN=prevN.next;
        }
        //second pass, set the randoms
        prevN = ret;
        prevO = head;
        while(prevO!=null){
            prevN.random=oldToNew.get(prevO.random);
            prevO=prevO.next;
            prevN=prevN.next;
        }
        return ret;
    }
}
/*
7>13>11>10>1>null

I mean, kind of spoiled for me. for the first pass:
make a deep copy of the normal list, no randoms
plus a hashmap from the original node to the new node

next pass, map the random, setting the randoms
*/

