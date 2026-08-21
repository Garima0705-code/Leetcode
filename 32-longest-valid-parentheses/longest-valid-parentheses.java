class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>() ;
        st.push(-1) ;
        int len = 0;
        int i = 0 ;
        while(i < s.length()){
            if(s.charAt(i) == '(') st.push(i) ;
            else{
                st.pop() ;
                if(st.size() == 0) st.push(i) ;
                else len = Math.max(len , i - st.peek()) ;
            }
            i++ ;
        }
        return len ;
    }
}