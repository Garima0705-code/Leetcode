class Solution {
    public void bfs(int[][] adj , int root , boolean[] visit){
        Queue<Integer> q = new LinkedList<>() ;
        visit[root] = true ;
        q.add(root) ;
        while(!q.isEmpty()){
            int front = q.remove() ;
            int m = adj[front].length ;
            for(int j = 0 ; j < m ; j++){
                if(front != j && adj[front][j] == 1){
                    if(visit[j] == false){
                        q.add(j) ;
                        visit[j] = true ;
                    } 
                }
            }
        }
    }
    public int findCircleNum(int[][] adj) {
        int n = adj.length ;
        boolean[] visit = new boolean[n] ;
        int count = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(visit[i] == false){
                bfs(adj ,i ,  visit) ;
                count++ ;
            }
        }
        return count ;
    }
}