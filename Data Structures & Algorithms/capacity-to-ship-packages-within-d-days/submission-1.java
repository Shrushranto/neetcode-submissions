class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        for(int weight : weights){
            l = Math.max(l, weight);
        }
        int u = 0;
        for(int w : weights){
            u += w;
        }


        int ans = Integer.MAX_VALUE;

        while(l<=u){
            int maxCapacity = l + (u-l)/2;
            int ships = 0;
            int curWeight = 0;
            for(int i=0; i<weights.length; i++){
                curWeight += weights[i];
                if(curWeight > maxCapacity){
                    ships++;
                    i = i-1;
                    curWeight = 0;
                }
            }
            if(curWeight >= maxCapacity || curWeight <= maxCapacity) ships++;

            if(ships == days){
                ans = Math.min(ans, maxCapacity);
                u = maxCapacity - 1;
            }else if(ships > days){
                l = maxCapacity + 1;
            }else{
                ans = Math.min(ans, maxCapacity);
                u = maxCapacity - 1;
            }

        }
        return ans;
    }
}