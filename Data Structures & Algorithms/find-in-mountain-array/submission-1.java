/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
         int length = mountainArr.length();


        //  lets find the peak element
        int l=0;
        int r = length - 1;
        int peak = 0;
        while(l<r){
            int mid  = l + (r-l)/2;
            if(mountainArr.get(mid) < mountainArr.get(mid+1)){
                l = mid+1;
            }else{
                r = mid; 
            }
        }
        peak = l;

        // lets search in left array from mid 
        int lt=0;
        int rt=peak;
        while(lt<=rt){
            int m = lt+(rt-lt)/2;
            if(mountainArr.get(m) == target){
                return m;
            }
            if(mountainArr.get(m) > target){
                rt = m - 1; 
            }else{
                lt = m + 1;
            }
        }

        int ltt=peak+1;
        int rtt=length-1;
        while(ltt<=rtt){
            int m = ltt+(rtt-ltt)/2;
            if(mountainArr.get(m) == target){
                return m;
            }
            if(mountainArr.get(m) > target){
                ltt = m + 1; 
            }else{
                rtt = m - 1;
            }
        }

        return -1;

    }
}