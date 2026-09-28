class Solution {
    public void bfs(int[][] isConnected, boolean[] isVisited, int idx){
        int n = isConnected.length ;
        Queue<Integer> q = new LinkedList<>() ;
        q.add(idx) ;
        isVisited[idx] = true ;
        while(q.size() > 0){
            int front = q.remove() ;
            for(int i = 0 ; i < n ; i++){
                if(isConnected[front][i] == 1 && isVisited[i] == false){
                    q.add(i) ;
                    isVisited[i] = true ;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length ;
        Queue<Integer> q = new LinkedList<>() ;
        boolean[] isVisited = new boolean[n] ;
        int provinces = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(!isVisited[i]){
                bfs(isConnected, isVisited, i);
                provinces++ ;
            }
        }
        return provinces ;
    }
}