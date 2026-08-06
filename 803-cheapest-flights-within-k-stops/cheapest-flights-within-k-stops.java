class Solution {
    class Pair{
        int next ;
        int cost ;
        Pair(int next, int cost){
            this.next = next ;
            this.cost = cost ;
        }
    }
    class Triplet{
        int next ;
        int cost ;
        int stops ;
        Triplet(int next, int cost, int stops){
            this.next = next ;
            this.cost = cost ;
            this.stops = stops ;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>() ;
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>()) ;
        for(int i = 0 ; i < flights.length ; i++){
            int from = flights[i][0] ;
            int to = flights[i][1] ;
            int cost = flights[i][2] ;
            adj.get(from).add(new Pair(to, cost)) ;
        }
        int[] ans = new int[n] ;
        Arrays.fill(ans, Integer.MAX_VALUE) ;
        ans[src] = 0 ;
        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(src, 0, 0));
        while(q.size() > 0){
            Triplet front = q.remove();
            int next = front.next ;
            int cost = front.cost ;
            int stops = front.stops ;
            if(stops == k+1) continue ;
            for(Pair p : adj.get(next)){
                int total = p.cost + cost ;
                if(total < ans[p.next]){
                    ans[p.next] = total ;
                    q.add(new Triplet(p.next, total, stops+1));
                }
            }
        }
        if(ans[dst] == Integer.MAX_VALUE) return -1;
        return ans[dst] ;
    }
}