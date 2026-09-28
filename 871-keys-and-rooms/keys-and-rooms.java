class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size() ;
        Queue<Integer> q = new LinkedList<>() ;
        boolean[] visit = new boolean[n] ;
        q.add(0) ;
        visit[0] = true ;
        while(q.size() > 0){
            int front = q.remove() ;
            for(int ele : rooms.get(front)){
                if(!visit[ele]){
                    q.add(ele) ;
                    visit[ele] = true ;
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(visit[i] == false) return false ;
        }
        return true ;
    }
}