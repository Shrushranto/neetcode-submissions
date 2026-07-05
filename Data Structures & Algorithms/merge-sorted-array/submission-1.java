class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l_valid = m - 1;

        int r_valid = n - 1; 

        int endPointer = nums1.length - 1;
        while(l_valid >= 0 && r_valid >= 0){
            if(nums2[r_valid] > nums1[l_valid]){
                nums1[endPointer--] = nums2[r_valid--];
            }else{
                nums1[endPointer--] = nums1[l_valid--];
            }
        }

        while(endPointer >= 0 && r_valid >= 0){
            nums1[endPointer--] = nums2[r_valid--];
        }
    }
}