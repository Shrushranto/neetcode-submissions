class Solution {
    public boolean isValid(String s) {
        if(s.length() <= 1){
            return false;
        }
        HashMap<Character, Character> mp = new HashMap<>();
        mp.put(')','(');
        mp.put('}','{');
        mp.put(']','[');
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ')' || c == '}' || c==']'){
                if(!stk.isEmpty() && (mp.get(c) == stk.peek())){
                    stk.pop();
                }else{
                    return false;
                }
            }else{
                stk.push(c);
            }
        }

        if(stk.isEmpty()){
            return true;
        }

        return false;
    }
}
