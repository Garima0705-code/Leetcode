class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>() ;
        int i = 0 ; 
        StringBuilder sb = new StringBuilder() ;
        while(i < s.length()){
            char ch = s.charAt(i) ;
            int x = (int)ch ;
            if(ch == '(' || x>=97 && x<=122){
                st.push(ch) ;
            }else{
                while(st.size() > 0 && st.peek() != '('){
                    sb.append(st.pop()) ;
                }
                if(st.size() > 0) st.pop() ;
                int j = 0 ;
                while(j < sb.length()){
                    st.push(sb.charAt(j)) ;
                    j++;
                }
                sb.setLength(0) ;
            }
            i++ ;
        }
        while(!st.isEmpty()){
            sb.append(st.pop()) ;
        }
        return sb.reverse().toString() ;
    }
}