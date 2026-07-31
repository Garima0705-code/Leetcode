class Solution {
    class Pair implements Comparable<Pair>{
        int des ;
        int cost ;
        Pair(int des, int cost){
            this.des = des ;
            this.cost = cost ;
        }
        public int compareTo(Pair p){
            return this.cost-p.cost ;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] cost = new int[n+1] ;
        cost[k] = 0 ;
        for(int i = 1 ; i <= n ; i++) if(i != k) cost[i] = Integer.MAX_VALUE ;
        List<List<Pair>> adj = new ArrayList<>() ;
        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>()) ;
        }
        for(int i = 0 ; i < times.length ; i++){
            int idx = times[i][0] ;
            int des = times[i][1] ;
            int amt = times[i][2] ;
            adj.get(idx).add(new Pair(des,amt)) ;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>() ;
        pq.add(new Pair(k,0));
        while(pq.size() > 0){
            Pair p = pq.remove() ;
            int parent = p.des ;
            int dist = p.cost ;
            if(dist <= cost[parent]){
                for(Pair s : adj.get(parent)){
                    int total = dist + s.cost ;
                    if(total < cost[s.des]){
                        pq.add(new Pair(s.des,total)) ;
                        cost[s.des] = total ;
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE ;
        for(int ele : cost)
            if(ele > max) max = ele ;
        return (max == Integer.MAX_VALUE)? -1 : max ;
    }
}