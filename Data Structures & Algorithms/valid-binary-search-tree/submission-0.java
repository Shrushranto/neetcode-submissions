/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        return checkValid(root, left, right);
    }

    private boolean checkValid(TreeNode root, int left, int right){
        if(root == null) return true;
        if(root.val >= right || root.val <= left){
            return false;
        }

        return(
            checkValid(root.left, left, root.val) && 
            checkValid(root.right, root.val, right)
        );
    }
}
