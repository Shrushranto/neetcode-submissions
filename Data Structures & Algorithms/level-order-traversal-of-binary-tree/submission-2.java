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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int qSize = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<qSize; i++){
                TreeNode curr = q.poll();
                if(curr != null){
                    level.add(curr.val);
                    q.offer(curr.left);
                    q.offer(curr.right);
                }
            }
            if(level.size() != 0){
                res.add(level);
            }
        }
        return res;
    }
}
