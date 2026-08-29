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
public class Solution {
    public int rob(TreeNode root) {
        // if (root == null) {
        //     return 0;
        // }

        // int res = root.val;
        // if (root.left != null) {
        //     res += rob(root.left.left) + rob(root.left.right);
        // }
        // if (root.right != null) {
        //     res += rob(root.right.left) + rob(root.right.right);
        // }

        // res = Math.max(res, rob(root.left) + rob(root.right));
        // return res;
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }

        int[] leftPair = dfs(root.left);
        int[] rightPair = dfs(root.right);

        int withRoot = root.val + leftPair[1] + rightPair[1]; 
        int withoutRoot = Math.max(leftPair[0], leftPair[1]) + Math.max(rightPair[0], rightPair[1]);

        return new int[]{withRoot, withoutRoot};
    }
}














