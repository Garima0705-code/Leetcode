class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int m = graph.length ;
        for(int i = 0 ; i < m ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < graph[i].length ; j++){
                int ele = graph[i][j];
                adj.get(ele).add(i);
            }
        }
        int[] inorder = new int[m] ;
        for(int i = 0 ; i < m ; i++){
            for(int ele : adj.get(i)){
                inorder[ele]++ ;
            }
        }
        Queue<Integer> q = new LinkedList<>() ;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < m ; i++) if(inorder[i] == 0) q.add(i) ;
        while(q.size()>0){
            int front = q.remove();
            ans.add(front);
            for(int ele : adj.get(front)){
                inorder[ele]-- ;
                if(inorder[ele]==0) q.add(ele);
            }
        }
        Collections.sort(ans) ;
        return ans;
    }
}