class Solution {
    public int calPoints(String[] operations) {
        int result = 0;
        Stack<Integer> recordStack = new Stack<>();

        for(String s : operations){
            if(Character.isDigit(s.charAt(0)) || ((s.length()>1) && (s.charAt(0) == '-'))){
                recordStack.push(Integer.parseInt(s));
            }else if(s.equals("+")){
                int n1 = recordStack.pop();
                int n2 = recordStack.pop();
                int sum = n1+n2;

                recordStack.push(n2);
                recordStack.push(n1);
                recordStack.push(sum);
            }else if(s.equals("C")){
                recordStack.pop();
            }else if(s.equals("D")){
                int prevScore = recordStack.pop();
                recordStack.push(prevScore);
                recordStack.push(2*prevScore);
            }
        }

        while(!recordStack.isEmpty()){
            result += recordStack.pop();
        }

        return result;
    }
}