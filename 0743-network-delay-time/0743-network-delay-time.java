class Solution {
    public int networkDelayTime(int[][] times, int n, int src) {
        int[] dist = new int[n+1] ;
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[src] = 0 ;
        for(int i = 1 ; i <= n-1 ; i++){
            for(int j = 0 ; j < times.length ; j++){
                if(dist[times[j][0]] == Integer.MAX_VALUE) continue ;
                int amount = times[j][2] + dist[times[j][0]] ;
                if(amount < dist[times[j][1]]) dist[times[j][1]] = amount ;
            }
        }
        int max = Integer.MIN_VALUE ;
        for(int i = 1 ; i < dist.length ; i++) max = Math.max(max , dist[i]) ;
        return (max == Integer.MAX_VALUE)? -1 : max ;
    }
}