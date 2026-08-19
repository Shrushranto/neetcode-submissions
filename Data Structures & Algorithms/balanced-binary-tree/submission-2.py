# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def getHeight(curr):
            if not curr:
                return 0

            left = getHeight(curr.left)
            right = getHeight(curr.right)

            return 1+ max(left,right)

        if not root:
            return True

        leftHeight = getHeight(root.left)
        rightHeight = getHeight(root.right)
        if(abs(leftHeight - rightHeight) > 1):
            return False
        return self.isBalanced(root.left) and self.isBalanced(root.right) 

       
