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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            List<TreeNode> stk = new ArrayList<>();
            int cur_size = q.size();

            for(int i=0; i<cur_size; i++){
                TreeNode curr = q.poll();
                stk.add(curr);

                if(curr.right != null){
                    q.offer(curr.right);
                }

                if(curr.left != null){
                    q.offer(curr.left);
                }
                
            }
            ans.add(stk.get(0).val);
        }
        
        return ans;
    }
}
