// class Solution {
//     public String minWindow(String s, String t) {
//         int minSize = Integer.MIN_VALUE;
//         HashMap<Character, Integer> mp1 = new HashMap<>();
//         HashMap<Character, Integer> mp2 = new HashMap<>();

//         for(char c : t.toCharArray()){
//             mp1.put(c, mp1.getOrDefault(c, 0)+1);
//             mp2.put(c,0);
//         }

//         int l = 0;
//         int r = 0;
//         int count = 0;
//         // StringBuilder sb = new StringBuilder();
//         int curLen = 0;
//         int st = 0;
//         int e = 0;

//         while(r<s.length()){
//             while(count == t.length()){
//                 if(mp2.containsKey(s.charAt(l))){
//                     mp2.put(s.charAt(l), mp2.get(s.charAt(l)) - 1);
//                     if(mp2.get(s.charAt(l)) == 0){
//                         // mp2.remove(s.charAt(l));
//                         count -= 1;
//                     }
//                 }
//                 l++;
//                 if((curLen > r-l+1) && (count == t.length())){
//                     curLen = r-l+1;
//                     st=l;
//                     e=r;
//                 } 
//             }
//             if(mp1.containsKey(s.charAt(r))){
//                 char c = s.charAt(r);
//                 mp2.put(c,mp2.getOrDefault(c,0)+1);
//                 count += 1;
//                 curLen = r-l+1;
//             }else{
//                 curLen = r-l+1;
//             }
//             r++;
//             if(curLen > r-l+1){
//                 curLen = r-l+1;
//                 st = l;
//                 e = r;
//             }
//         }

//         return s.substring(st,e);
//     }
// }


class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> mp1 = new HashMap<>();
        HashMap<Character, Integer> mp2 = new HashMap<>();

        for (char c : t.toCharArray()) {
            mp1.put(c, mp1.getOrDefault(c, 0) + 1);
            mp2.put(c, 0);
        }

        int l = 0, r = 0;
        int count = 0;

        int minSize = Integer.MAX_VALUE;
        int st = 0;

        while (r < s.length()) {

            char c = s.charAt(r);

            if (mp1.containsKey(c)) {
                mp2.put(c, mp2.get(c) + 1);

                if (mp2.get(c) <= mp1.get(c)) {
                    count++;
                }
            }

            while (count == t.length()) {

                if (r - l + 1 < minSize) {
                    minSize = r - l + 1;
                    st = l;
                }

                char left = s.charAt(l);

                if (mp1.containsKey(left)) {
                    mp2.put(left, mp2.get(left) - 1);

                    if (mp2.get(left) < mp1.get(left)) {
                        count--;
                    }
                }

                l++;
            }

            r++;
        }

        if (minSize == Integer.MAX_VALUE)
            return "";

        return s.substring(st, st + minSize);
    }
}
