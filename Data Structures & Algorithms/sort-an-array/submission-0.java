class Solution {
    public int[] sortArray(int[] nums) {
        return divide(0, nums.length-1, nums);
    }
    public int[] divide(int l, int r, int[] nums){
        if(l>=r){
            return new int[]{nums[l]};
        }

        int mid = l+(r-l)/2;
        int[] leftArr = divide(l,mid,nums);
        int[] rightArr = divide(mid+1,r, nums);

        return merge(leftArr, rightArr);
    }

    public int[] merge(int[] arr1, int[] arr2){
        int[] mergedArr = new int[arr1.length + arr2.length];
        int l1 = 0;
        int l2 = 0;
        int idx = 0;

        while(l1<arr1.length && l2<arr2.length){
            if(arr1[l1] <= arr2[l2]){
                mergedArr[idx++] = arr1[l1++];
            }else{
                mergedArr[idx++] = arr2[l2++];
            }
        }

        while(l1<arr1.length){
            mergedArr[idx++] = arr1[l1++];
        }
        while(l2<arr2.length){
            mergedArr[idx++] = arr2[l2++];
        }

        return mergedArr;
    }
}