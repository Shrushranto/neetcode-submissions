class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rs = matrix.length;
        int c = matrix[0].length;
        int l = 0;
        int r = (rs * c)-1;

        while(l<=r){
            int mid = l+(r-l)/2;
            int ans = matrix[mid/c][mid%c];

            if(ans == target){
                return true;
            }else if(ans < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return false;
    }
}
