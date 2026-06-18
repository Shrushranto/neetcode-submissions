class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // at most there will be none or 2 majority elements

        int cnt1 = 0;
        int cnt2 = 0;
        int e1 = Integer.MIN_VALUE;
        int e2 = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            if(cnt1 == 0 && e2 != nums[i]){
                cnt1++;
                e1 = nums[i];
            }else if(cnt2 == 0 && e1 != nums[i]){
                cnt2++;
                e2 = nums[i];
            }else if(nums[i] == e1){
                cnt1++;
            }else if(nums[i] == e2){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }

        int freq1 = 0;
        int freq2 = 0;

        List<Integer> ans = new ArrayList<>();
        for(int i : nums){
            if(i == e1) freq1++;
            if(i == e2) freq2++;
        }

        if(freq1 > (int)Math.floor(nums.length/3)){
            ans.add(e1);
        }
        if(freq2 > (int)Math.floor(nums.length/3)){
            ans.add(e2);
        }

        return ans;

    }
}