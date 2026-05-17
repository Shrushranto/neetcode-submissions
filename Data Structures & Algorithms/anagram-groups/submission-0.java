class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        String[] str = new String[strs.length];
        for(int i=0; i<str.length; i++){
            char[] word = strs[i].toCharArray();
            Arrays.sort(word);
            str[i] = new String(word);
        }

        boolean[] visited = new boolean[strs.length];
        for(int s=0; s<str.length;s++){
            if(visited[s] == true) continue;
            List<String> anagrams = new ArrayList<>();
            String curr = str[s];
            anagrams.add(strs[s]);
            visited[s] = true;
            for(int j=s+1; j<str.length; j++){
                if(str[j].equals(curr) && visited[j] != true){
                    anagrams.add(strs[j]);
                    visited[j] = true;
                }
            }
            ans.add(anagrams);
        }

        return ans;
    }
}
