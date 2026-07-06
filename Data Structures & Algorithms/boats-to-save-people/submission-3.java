class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;

        int boat = 0;
        while(l<r){
            int curWeight = people[l] + people[r];
            if(curWeight > limit){
                r--;
                boat += 1;
            }else if(curWeight <= limit){
                r--;
                l++;
                boat += 1;
            }
        }
        if(l == r){
            boat += 1;
        }

        return boat;
    }
}