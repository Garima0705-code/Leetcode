class Solution {
    class Triplet implements Comparable<Triplet>{
        int ele ;
        int parent ;
        int dist ;
        Triplet(int ele , int parent , int dist){
            this.ele = ele ;
            this.parent = parent ;
            this.dist = dist ;
        }
        public int compareTo(Triplet t){
            return this.dist-t.dist;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int m = points.length ;
        boolean[] visit = new boolean[m] ;
        int sum = 0 ;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0,-1,0));
        while(pq.size() > 0){
            Triplet t = pq.remove();
            if(visit[t.ele]) continue ;
            visit[t.ele] = true ;
            sum += t.dist ;
            for(int i = 0 ; i < m ; i++){
                if(visit[i] == true) continue ;
                if(i != t.ele && i != t.parent){
                    int x2 = points[i][0] , y2 = points[i][1] ;
                    int x1 = points[t.ele][0] , y1 = points[t.ele][1] ;
                    int dist = Math.abs(x1-x2) + Math.abs(y1-y2) ;
                    pq.add(new Triplet(i , t.ele , dist));
                }
            }
        }
        return sum;
    }
}