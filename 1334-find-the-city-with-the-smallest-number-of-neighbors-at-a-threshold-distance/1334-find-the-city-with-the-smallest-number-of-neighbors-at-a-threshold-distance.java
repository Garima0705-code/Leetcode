class Solution {
    public int findTheCity(int n, int[][] edges, int d) {
        int[][] adj = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == j) adj[i][j] = 0 ;
                else adj[i][j] = Integer.MAX_VALUE ;
            }
        }
        for(int i = 0 ; i < edges.length ; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            int wt = edges[i][2];
            adj[a][b] = wt ;
            adj[b][a] = wt ;
        }
        for(int k = 0 ; k < n ; k++){
            for(int i = 0 ; i < n ; i++){
                if(i == k) continue ;
                for(int j = 0 ; j < n ; j++){
                    if(i == j || j == k) continue ;
                    if(adj[i][k] == Integer.MAX_VALUE || adj[k][j] == Integer.MAX_VALUE) continue ;
                    int cost = adj[i][k] + adj[k][j];
                    adj[i][j] = Math.min(cost, adj[i][j]);
                }
            }
        }
        int[] ans = new int[n] ;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(adj[i][j] <= d) ans[i]++ ;
            }
        }
        int min = Integer.MAX_VALUE ;
        int idx = -1 ;
        for(int i = 0 ; i < n ; i++){
            if(ans[i] <= min){
                min = ans[i];
                idx = i ;
            }
        } 
        return idx ;
    }
}