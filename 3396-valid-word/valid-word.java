class Solution {
    public boolean isVowel(char s){
        if(s == 'a' || s == 'A') return true ;
        if(s == 'e' || s == 'E') return true ;
        if(s == 'i' || s == 'I') return true ;
        if(s == 'o' || s == 'O') return true ;
        if(s == 'u' || s == 'U') return true ;
        return false ;
    }
    public boolean isNumber(char s){
        int ascii = (int)s ;
        if(ascii >= 48 && ascii <= 57) return true ;
        return false ;
    }
    public boolean isLetter(char s){
        int ascii = (int)s ;
        if((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122)) return true ;
        return false ;
    }
    public boolean isValid(String word) {
        int n = word.length() ;
        if(n < 3) return false ;
        boolean isVowel = false ;
        boolean isConsonant = false ;
        for(int i = 0 ; i < n ; i++){
            char ch = word.charAt(i) ;
            if(isLetter(ch)){
                if(isVowel(ch)) isVowel = true ;
                else isConsonant = true ;
            }
            else if(!isNumber(ch)) return false ;
        }
        return (isVowel && isConsonant);
    }
}