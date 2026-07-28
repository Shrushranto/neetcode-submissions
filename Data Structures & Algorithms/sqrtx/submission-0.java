class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int l = 1;
        int r = x;
        int ans = 0;

        while(l<=r){
            int mid = l+((r-l)/2);
            long sq = (long) mid * mid;

            if(sq == x){
                return mid;
            }else if(sq > x){
                r = mid - 1;
            }else{
                ans = mid;
                l = mid + 1;
            }
        }

        return ans;
    }
}