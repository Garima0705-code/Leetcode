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
    class Pair implements Comparable<Pair>{
        int ele ;
        ListNode row;
        Pair(int ele, ListNode row){
            this.ele = ele ;
            this.row = row ;
        }
        public int compareTo(Pair t){
            return Integer.compare(this.ele, t.ele) ;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length ;
        //if(n == 0) return new ListNode() ;
        PriorityQueue<Pair> heap = new PriorityQueue<>() ;
        for(int i = 0 ; i < n ; i++){
            if(lists[i] == null) continue ;
            ListNode next = lists[i].next ;
            int ele = lists[i].val ;
            heap.add(new Pair(ele, next)) ;
        }
        ListNode ans = new ListNode(-1) ;
        ListNode temp = ans ;
        while(heap.size() > 0){
            Pair top = heap.remove() ;
            int ele = top.ele ;
            temp.next = new ListNode(ele) ;
            temp = temp.next ;
            ListNode next = top.row ;
            if(next != null) heap.add(new Pair(next.val , next.next)) ;
        }
        return ans.next ;
    }
}