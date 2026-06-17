class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        char[] str = s.toCharArray();
        
        for (char a : str){
            if(a == '(' ||a == '{' ||a == '['){
                st.push(a);
            }
            else if (a == ')' || a == '}' || a== ']'){
                if(st.isEmpty()){
                    return false;
                }
                char top = st.pop();
                if ((a == ')' && top != '(') ||
                    (a == '}' && top != '{') ||
                    (a == ']' && top != '[')) {

                    return false;
                }

                 
            }
        }
        return st.isEmpty();

    }
}
