class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int l = 1;
        int r = piles[piles.length - 1];

        int ans = 0;

        while(l<=r){
            int mid = l + (r-l)/2;
            int totalTime = 0;
            for(int p : piles){
                totalTime += Math.ceil(((double)p)/(double)mid);
            }
            if(totalTime <= h){
                ans = mid;
                r = mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;

    }
}
