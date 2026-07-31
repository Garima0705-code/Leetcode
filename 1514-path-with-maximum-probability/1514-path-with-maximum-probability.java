class Solution {
    class Pair implements Comparable<Pair>{
        int next;
        double prob;
        Pair(int next, double prob){
            this.next = next ;
            this.prob = prob ;
        }
        public int compareTo(Pair p){
            return Double.compare(p.prob , this.prob);
        }
    }
    public double maxProbability(int n, int[][] arr, double[] suc, int src, int end) {
        int len = arr.length ;
        double[] ans = new double[n];
        Arrays.fill(ans, Integer.MIN_VALUE);
        ans[src] = 0;
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n ; i++) adj.add(new ArrayList<>()) ;
        for(int i = 0 ; i < len; i++){
            int a = arr[i][0];
            int b = arr[i][1];
            double pro = suc[i] ;
            adj.get(a).add(new Pair(b, pro));
            adj.get(b).add(new Pair(a, pro));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 1));
        while(pq.size() > 0){
            Pair p = pq.remove();
            int top = p.next;
            double profit = p.prob ;
            if(profit >= ans[top]){
                for(Pair ele : adj.get(top)){
                    double total = ele.prob*profit ;
                    if(total > ans[ele.next]){
                        pq.add(new Pair(ele.next, total));
                        ans[ele.next] = total ;
                    }
                }
            }
        }
        if(ans[end]==Integer.MIN_VALUE) return 0;
        return ans[end];
    }
}