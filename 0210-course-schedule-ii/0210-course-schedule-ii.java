class Solution {
    public void topo(List<Integer> ans , List<List<Integer>> adj, int[] in){
        Queue<Integer> q = new LinkedList<>() ;
        for(int i = 0 ; i < in.length ; i++){
            if(in[i] == 0){
                q.add(i) ;
                ans.add(i) ;
            } 
        }
        while(q.size()>0){
            int front = q.remove() ;
            for(int ele : adj.get(front)){
                in[ele]-- ;
                if(in[ele] == 0){
                    q.add(ele);
                    ans.add(ele);
                } 
            }
        }
    }
    public int[] findOrder(int n, int[][] arr) {
        List<List<Integer>> adj = new ArrayList<>() ;
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());
        int m = arr.length ;
        for(int i = 0 ; i < m ; i++){
            int a = arr[i][0] ;
            int b = arr[i][1] ;
            adj.get(b).add(a) ;
        }
        List<Integer> ans = new ArrayList<>() ;
        int[] in = new int[n] ;
        for(int i = 0 ; i < n ; i++){
            for(int ele : adj.get(i)){
                in[ele]++ ;
            }
        }
        topo(ans,adj,in) ;
        int len = ans.size() ;
        int[] list = new int[len] ;
        if(ans.size() != n) return new int[0] ;
        for(int i = 0 ; i < len ; i++) list[i] = ans.get(i) ;
        return list ;
    }
}