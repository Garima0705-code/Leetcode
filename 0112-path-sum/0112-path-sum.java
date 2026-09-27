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
    public boolean hasPathSum(TreeNode root, int target) {
        if(root == null) return false ;
        if(root.left == null && root.right == null){
            if(target == root.val) return true ;
            else return false ;
        }
        target -= root.val ;
        boolean x = hasPathSum(root.left, target) ;
        boolean y = hasPathSum(root.right, target) ;
        return x || y ;
    }
}