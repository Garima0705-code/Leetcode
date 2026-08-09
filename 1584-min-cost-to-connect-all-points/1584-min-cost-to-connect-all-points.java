class Solution {
    class Triplet implements Comparable<Triplet>{
        int x ;
        int y ;
        int dist ;
        Triplet(int x , int y , int dist){
            this.x = x ;
            this.y = y ;
            this.dist = dist ;
        }
        public int compareTo(Triplet t){
            return this.dist-t.dist;
        }
    }
    public int leader(int u, int[] parent){
        if(parent[u] == u) return u;
        return parent[u] = leader(parent[u], parent) ;
    }
    public void union(int u, int v, int[] parent, int[] size){
        int a = leader(u, parent) ;
        int b = leader(v, parent) ;
        if(size[a] > size[b]){
            parent[b] = a;
            size[a] += size[b] ;
        }else{
            parent[a] = b;
            size[b] += size[a] ;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length ;
        PriorityQueue<Triplet> pq = new PriorityQueue<>() ;
        for(int i = 0; i < n ; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j = 0 ; j < n ; j++){
                if(i == j) continue ;
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1-x2) + Math.abs(y1-y2) ;
                pq.add(new Triplet(i,j,dist)) ;
            }
        }
        int[] parent = new int[n] ;
        int[] size = new int[n] ;
        for(int i = 0 ; i < n ; i++){
            parent[i] = i ;
            size[i] = 1;
        }
        int min = 0;
        while(pq.size() > 0){
            Triplet t = pq.remove() ;
            int u = t.x ;
            int v = t.y ;
            if(leader(u, parent) != leader(v, parent)){
                min += t.dist ;
                union(u,v, parent,size);
            }
        }
        return min;
    }
}