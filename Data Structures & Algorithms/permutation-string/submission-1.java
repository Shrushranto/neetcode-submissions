class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int  n = s1.length(); //will act as our window size

        int l = 0;
        int r = 0;

        HashMap<Character, Integer> mp1 = new HashMap<>();
        HashMap<Character, Integer> mp2 = new HashMap<>();

        for(char c: s1.toCharArray()){
            mp1.put(c,mp1.getOrDefault(c, 0)+1);
        }

        while(r<s2.length()){
            char c = s2.charAt(r);
            mp2.put(c, mp2.getOrDefault(c,0)+1);
            if((r-l+1) > n){
                mp2.put(s2.charAt(l), mp2.get(s2.charAt(l)) - 1);
                if(mp2.get(s2.charAt(l)) == 0){
                    mp2.remove(s2.charAt(l));
                }
                l++;
            }
            if(mp1.equals(mp2)){
                return true;
            }
            r++;
        }

        return false;
    }
}
