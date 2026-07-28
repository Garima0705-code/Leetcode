class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size() ;
        boolean[] visit = new boolean[n] ;
        visit[0] = true ;
        Queue<Integer> q = new LinkedList<>() ;
        q.add(0) ;
        while(q.size() > 0){
            int front = q.remove() ;
            int len = rooms.get(front).size() ;
            for(int i = 0 ; i < len ; i++){
                int key = rooms.get(front).get(i) ;
                if(!visit[key]){
                    visit[key] = true ;
                    q.add(key) ;
                }
            }
        }
        for(boolean ele : visit) 
            if(ele == false) return false ;
        return true ;
    }
}