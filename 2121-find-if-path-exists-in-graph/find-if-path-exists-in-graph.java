class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>() ;
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>()) ;
        }
        for(int i = 0 ; i < edges.length ; i++){
            int a = edges[i][0] ;
            int b = edges[i][1] ;
            adj.get(a).add(b) ;
            adj.get(b).add(a) ;
        }
        Queue<Integer> q = new LinkedList<>() ;
        boolean[] visit = new boolean[n] ;
        q.add(source) ;
        visit[source] = true ;
        while(q.size() > 0){
            int front = q.remove() ;
            for(int ele : adj.get(front)){
                if(!visit[ele]){
                    q.add(ele) ;
                    visit[ele] = true ;
                }
            }
        }
        return visit[destination] ;
    }
}