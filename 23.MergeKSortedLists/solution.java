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
public class IndexedHead{
    int idx;
    ListNode head;
    public IndexedHead(int idx, ListNode head){
        this.idx=idx;
        this.head=head;
    }
    //to move to next, need to
    //look at the polled node
    //check the null of curr.head.next
    //then if not null, add it
    //doing it in a function wont heapify i think
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<IndexedHead> heap = 
            new PriorityQueue<IndexedHead>((a,b)->a.head.val-b.head.val);
        for(int i=0; i<lists.length; i++){
            if(lists[i]!=null){
                IndexedHead temp = new IndexedHead(i,lists[i]);
                heap.add(temp);
            }
        }
        ListNode head = null;
        ListNode prev = null;
        while(!heap.isEmpty()){
            IndexedHead curr = heap.poll();
            //add to the ret
            if(head==null){
                head = curr.head;
                prev = curr.head;
            }
            else{
                prev.next = curr.head;
                prev = prev.next;
            }
            //get the next
            if(curr.head.next!=null){
                heap.add(new IndexedHead(curr.idx,curr.head.next));
            }
        }
        return head;
    }
}
/*
so indexedHead
    idx
    ListNode head
and the heap is full of these indexed heads

4 5
3 4
2 6

1 1

3
4

uhh min heap?
get a head on each ll
add all the vals to the heap, min on ln.val
probably need a wrapper class to store idx
*/
