class Solution {
    public String decodeString(String s) {

        Stack<Integer> stackNum = new Stack<>();
        Stack<String> stack = new Stack<>();

        StringBuilder curr = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');  
            }

            else if (Character.isLetter(c)) {
                curr.append(c);
            }

            else if (c == '[') {
                stackNum.push(num);
                stack.push(curr.toString());

                num = 0;
                curr = new StringBuilder();
            }

            else if (c == ']') {

                int cnt = stackNum.pop();
                String prev = stack.pop();

                String repeated = curr.toString().repeat(cnt);

                curr = new StringBuilder(prev + repeated);
            }
        }

        return curr.toString();
    }
}