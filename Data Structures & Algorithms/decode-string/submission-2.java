class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == ']'){
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && !stack.peek().equals("[")){
                    sb.insert(0,stack.pop());
                }
                stack.pop();
                StringBuilder num = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))){
                    num.insert(0, stack.pop());
                }
                int k = Integer.parseInt(num.toString());

                String updatedString = sb.toString().repeat(k);
                stack.push(updatedString);
            }else{
                stack.push(String.valueOf(c));
            }
        }

        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.insert(0,stack.pop());
        }

        return ans.toString();
    }
}