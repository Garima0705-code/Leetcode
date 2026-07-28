class Solution {
    public void bfs(List<List<Integer>> adj, int s, boolean[] visit){
        Queue<Integer> q = new LinkedList<>() ;
        q.add(s) ;
        visit[s] = true ;
        while(q.size() > 0){
            int f = q.remove() ;
            for(int ele : adj.get(f)){
                if(!visit[ele]){
                    q.add(ele) ;
                    visit[ele] = true ;
                }
            }
        }
    }
    public boolean validPath(int m, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>() ;
        int n = edges.length ;
        for(int i = 0 ; i < m ; i++){
            adj.add(new ArrayList<>()) ;
        }
        for(int i = 0 ; i < n ; i++){
            int x = edges[i][0] ;
            int y = edges[i][1] ;
            adj.get(x).add(y) ;
            adj.get(y).add(x) ;
        }
        boolean[] visit = new boolean[m] ;
        bfs(adj , source, visit) ;
        return visit[destination] ;
    }
}