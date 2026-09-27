/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean subtree(TreeNode root, TreeNode p){
        if(root == null) return false ;
        if(root == p) return true ;
        boolean left = subtree(root.left, p);
        boolean right = subtree(root.right, p);
        return left || right ;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p == root || q == root) return root ;
        boolean pleft = subtree(root.left,p) ;
        boolean qleft = subtree(root.left,q) ;
        if(pleft == false && qleft == false) return lowestCommonAncestor(root.right,p,q) ; ;
        if(pleft == true && qleft == true) return lowestCommonAncestor(root.left,p,q) ;
        else return root ;
    }
}