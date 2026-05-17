class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        // int i = 0;
        
        int[] ans = new int[2*n];
        // while(i<n){
        //     ans[i] = nums[i];
        //     i++;
        // }
        // i = 0;
        // for(int j = n; j<ans.length; j++){
        //     ans[j] = nums[i++];
        // }

        int k = 0;
        for(int i=0; i<n; i++){
            ans[i] = nums[k];
            ans[i+n] = nums[k];
            k++;
        }

        return ans;
    }
}