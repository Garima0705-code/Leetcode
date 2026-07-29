class Solution {
    public void dfs(List<List<Integer>> rooms, boolean[] visit, int idx){
        visit[idx] = true ;
        for(int key : rooms.get(idx)){
            if(!visit[key]) dfs(rooms,visit,key);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int m = rooms.size() ;
        boolean[] visit = new boolean[m] ;
        dfs(rooms, visit,0) ;
        for(boolean ans : visit)
            if(ans == false) return false ;
        return true ;
    }
}