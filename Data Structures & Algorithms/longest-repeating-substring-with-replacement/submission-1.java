class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int maxLen = 0;
        int r = 0;

        HashMap<Character, Integer> mp = new HashMap<>();

        while(r<s.length()){
            int curLen = r-l+1;
            mp.put(s.charAt(r),mp.getOrDefault(s.charAt(r), 0)+1);
            
            if((curLen - getMax(mp)) <= k){
                maxLen = Math.max(maxLen, r-l+1);
            }else{
                mp.put(s.charAt(l),mp.get(s.charAt(l))-1);
                l++;
            }
            r++;
        }

        return maxLen;
    }

    public int getMax(HashMap<Character, Integer> map){
        int maxFreq = Integer.MIN_VALUE;
        for(int value : map.values()){
            maxFreq = Math.max(value, maxFreq);
        }
        return maxFreq;
    }
}
