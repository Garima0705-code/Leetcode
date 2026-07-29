class Solution {
    public void dfs(int[][] adj, boolean[] visit, int i) {
        visit[i] = true ;
        for(int j = 0; j < adj[i].length ; j++){
            if(i != j && adj[i][j] == 1 && !visit[j]){
                dfs(adj,visit,j) ;
            }
        }
    }
    public int findCircleNum(int[][] adj) {
        int m = adj.length ;
        int n = adj[0].length ;
        int count = 0 ;
        boolean[] visit = new boolean[m] ;
        for(int i = 0 ; i < m ; i++){
            if(!visit[i]){
                dfs(adj,visit,i) ;
                count++ ;
            }  
        }
        return count ;
    }
}