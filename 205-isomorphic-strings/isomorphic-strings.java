class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>() ;
        int i = 0 ;
        while(i < s.length()){
            char ch = s.charAt(i) ;
            if(map.containsKey(ch)){
                char p = map.get(ch) ;
                if(p != t.charAt(i)) return false ;
            }else map.put(ch, t.charAt(i)) ;
            i++ ;
        }
        map.clear() ;
        i = 0 ;
        while(i < t.length()){
            char ch = t.charAt(i) ;
            if(map.containsKey(ch)){
                char p = map.get(ch) ;
                if(p != s.charAt(i)) return false ;
            }else map.put(ch, s.charAt(i)) ;
            i++ ;
        }
        return true ;
    }
}