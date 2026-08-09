class Solution {
    public int leader(int u , int[] parent){
        if(parent[u] == u) return u ;
        return parent[u] = leader(parent[u], parent) ;
    }
    public void union(int u , int v, int[] parent, int[] size, boolean[] parity){
        int a = leader(u , parent);
        int b = leader(v , parent);
        if(size[a] > size[b]){
            parent[b] = a;
            size[a] += size[b];
            parity[v] = !parity[u] ;
        }else{
            parent[a] = b;
            size[b] += size[a];
            parity[u] = !parity[v] ;
        }
    }
    public boolean isBipartite(int[][] adj) {
        int n = adj.length ;
        int[] parent = new int[n] ;
        int[] size = new int[n] ;
        boolean[] parity = new boolean[n] ;
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
            size[i] = 1 ;
        }
        for(int i = 0 ; i < n ; i++){
            int u = i ;
            for(int ele : adj[i]){
                int v = ele ;
                int leaderU = leader(u,parent) ;
                int leaderV = leader(v,parent) ;
                if(leaderU == leaderV){
                    if(parity[u] == parity[v]) return false ;
                }else{
                    union(u,v,parent,size,parity) ;

                }
            }
        }
        return true ;
    }
}