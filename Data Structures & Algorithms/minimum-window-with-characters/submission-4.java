class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        HashMap<Character, Integer> mp1 = new HashMap<>();
        HashMap<Character, Integer> mp2 = new HashMap<>();

        for(char c : t.toCharArray()){
            mp1.put(c,mp1.getOrDefault(c,0)+1);
            mp2.put(c,0);
        }

        int minSize = Integer.MAX_VALUE;
        int start = 0;
        int l=0, r=0;
        int count = 0;

        while(r<s.length()){
            char c = s.charAt(r);

            if(mp1.containsKey(c)){
                mp2.put(c, mp2.getOrDefault(c,0)+1);
                if(mp2.get(c) <= mp1.get(c)){
                    count++;
                }
            }

            while(count == t.length()){
                char left = s.charAt(l);
                if(r-l+1 < minSize){
                    minSize = r-l+1;
                    start = l;
                }
                if(mp1.containsKey(left)){
                    mp2.put(left,mp2.get(left) - 1);
                    if(mp2.get(left) < mp1.get(left)){
                        count--;
                    }
                }
                l++;
            }
            r++;
        }

        if(minSize == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start, start+minSize);
    }
}
